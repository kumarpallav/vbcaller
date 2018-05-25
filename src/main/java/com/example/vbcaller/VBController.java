package com.example.vbcaller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//9144
@Controller
public class VBController {
	
	@GetMapping("/call")
	protected void caller(@RequestParam(name="script",required=false)String script) throws IOException{
		String scrptDir="c:\\framework\\";
		String scrpt="sample.vbs";
		if(script!=null && script.length()>0){
			scrpt=script;
		}
		callScript(scrptDir,scrpt);
	}

	private void callScript(String dir,String file) throws IOException {
		String script = dir+file;
		// search for real path:wscript.exe
		String executable = "C:\\windows\\System32\\wscript.exe"; 
		String cmdArr [] = {executable, script};
		Runtime.getRuntime ().exec (cmdArr);
		
	}

}
