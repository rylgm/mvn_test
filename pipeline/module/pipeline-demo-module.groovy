import hudson.model.*;
import groovy.json.*;

def find_files(filetype) {
	
	def files = findFiles(glob:filetype)
	for (file in files) {
		println file.name
	}
}

def read_json_file(file_path) {
	def propMap = readJSON file : file_path
	propMap.each {
	    println ( it.key + " = " + it.value )
	}
}

def read_json_file2(json_string) {
	def propMap = readJSON text : json_string
	propMap.each {
		println ( it.key + " = " + it.value )
	}
}

def write_json_to_file(input_json, output_path){
	def input = ''
	if (input_json.toString().endsWith(".json")){
		input = readJSON file : input_json
	}else{
		def jsonSlurper = new JsonSlurper()
		def new_json_object = jsonSlurper.parseText(input_json)
		input = new_json_object
	}
	writeJSON file : output_path, json: input
}

return this;
