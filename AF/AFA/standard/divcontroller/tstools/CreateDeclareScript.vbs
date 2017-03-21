
Option Explicit

main

sub main
	dim subGyomuCode,projectType,gyomuTsListFile,files
	subGyomuCode = WScript.Arguments(0)
	projectType = WScript.Arguments(1)
	gyomuTsListFile = WScript.Arguments(2)
	files = loadGyomuTsList(gyomuTsListFile,projectType)
	saveProjectFile files,subGyomuCode,projectType
end sub


' 
function loadGyomuTsList(gyomuTsListFile,projectType)
	dim tsfiles,inFso,inFile,tmpLine,formed,cnt,ary,i,res()
	set tsfiles = CreateObject("ADODB.Recordset")
	call tsfiles.Fields.Append("typescriptfile", 200, 1024)
	call tsfiles.Open()
	Set inFso = CreateObject("Scripting.FileSystemObject")
	Set inFile = inFso.OpenTextFile(gyomuTsListFile)
	cnt = 0
	Do Until inFile.AtEndOfStream
		tmpLine = inFile.ReadLine
		if(isTarget(tmpLine,projectType))Then
			call tsfiles.AddNew()
			tsfiles.Fields("typescriptfile") = """" & tmpLine & """"
			cnt = cnt + 1
		end if
	Loop
	inFile.close
	if(cnt > 0)Then
		call tsfiles.Update()
		tsfiles.Sort = "typescriptfile asc"
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



sub saveProjectFile(files,subGyomuCode,projectType)
	dim outFso,outFile,keys,i
	Set outFso = CreateObject("Scripting.FileSystemObject")
	Set outFile = outFso.CreateTextFile("$tmp2.txt", true)
	outFile.WriteLine "--out "".\" & subGyomuCode & "CommonChildDiv.js"" --target  ES5  --declaration"
	if(files(0) <> "nothing") then
		for i = 0 to Ubound(files)
			outFile.WriteLine files(i)
		next
	end if
	outFile.close
end sub



