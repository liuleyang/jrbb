
Option Explicit

main

sub main
	dim subGyomuCode,projectType,gyomuTsListFile,includeStatements
	subGyomuCode = WScript.Arguments(0)
	projectType = WScript.Arguments(1)
	gyomuTsListFile = WScript.Arguments(2)
	includeStatements = loadGyomuTsList(gyomuTsListFile,projectType)
	saveProjectFile includeStatements,subGyomuCode,projectType
end sub


' 
function loadGyomuTsList(gyomuTsListFile,projectType)
	dim tsfiles,inFso,inFile,tmpLine,formed,cnt,ary,i,res()
	set tsfiles = CreateObject("ADODB.Recordset")
	call tsfiles.Fields.Append("includeStatement", 200, 1024)
	call tsfiles.Open()
	Set inFso = CreateObject("Scripting.FileSystemObject")
	Set inFile = inFso.OpenTextFile(gyomuTsListFile)
	cnt = 0
	Do Until inFile.AtEndOfStream
		tmpLine = inFile.ReadLine
		if(isTarget(tmpLine,projectType))Then
			call tsfiles.AddNew()
			tsfiles.Fields("includeStatement") = formTypeScriptCompileFiles(tmpLine,projectType)
			cnt = cnt + 1
		end if
	Loop
	inFile.close
	if(cnt > 0)Then
		call tsfiles.Update()
		tsfiles.Sort = "includeStatement asc"
		ary = tsfiles.GetRows()
		redim res(cnt)
		for i=0 to Ubound(ary,2)
			res(i) = ary(0,i)
		next
	else
		redim res(0)
		res(0) = "nothing"
	end if
	tsfiles.Close()
	set tsfiles = Nothing
	loadGyomuTsList = res
end function



function isTarget(filename,projectType)
	dim res
	res = true
	if(instr(filename,"\src\main\webapp\WEB-INF\standard\" & projectType) = 0)Then
		res = false
	end if
	if((projectType = "CommonChildDiv") and instr(filename,"_Design.ts"))Then
		res = false
	end if
	if((projectType = "View") and (instr(filename,"_Script.ts") = 0))Then
		res = false
	end if
	isTarget = res
end function



Function formTypeScriptCompileFiles(filename,projectType)
	dim idx
	idx = instr(filename,"\src\main\webapp\WEB-INF\standard\" & projectType)
	filename = mid(filename,idx,len(filename)-idx+1)
	formTypeScriptCompileFiles 	 = "    <TypeScriptCompile Include=""." & filename & """ />"
end function



sub saveProjectFile(includeStatements,subGyomuCode,projectType)
	Dim inFso,inFile,tmpLine
	dim outFso,outFile,keys,i
	Set inFso = CreateObject("Scripting.FileSystemObject")
	Set inFile = inFso.OpenTextFile(projectType & ".template")
	Set outFso = CreateObject("Scripting.FileSystemObject")
	Set outFile = outFso.CreateTextFile(generateProjectFilename(subGyomuCode,projectType), true)
	Do Until inFile.AtEndOfStream
		tmpLine = inFile.ReadLine
		if(instr(tmpLine,"<!-- RootNamespace -->"))Then
			tmpLine = replace(tmpLine,"<!-- RootNamespace -->",subGyomuCode & projectType)
			outFile.WriteLine tmpLine
		elseif(instr(tmpLine,"<!-- TypeScriptCompileFiles -->"))Then
			if(includeStatements(0) <> "nothing") then
				for i = 0 to Ubound(includeStatements)
					outFile.WriteLine includeStatements(i)
				next
			end if
		else
			outFile.WriteLine tmpLine
		end if
	Loop
	inFile.close
	outFile.close
end sub



function generateProjectFilename(subGyomuCode,projectType)
	generateProjectFilename =  "..\"& subGyomuCode & projectType &".csproj"
end function


