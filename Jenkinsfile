import hudson.model.*;

println env.JOB_NAME
println env.BUILD_NUMBER

pipeline{
	agent any
	stages{
		stage('init'){
			steps{
				script{
					model_test = load env.WORKSPACE + "/pipeline/module/pipeline-demo-module.groovy"
				}
			}
		}
		stages("Parse json"){
			steps{
				script{
					json_file = env.WORKSPACE + "/testdata/test_json.json"
					model_test.read_json_file(json_file)
					println "==============================="
					json_string = '{"NAME":"Tom","AGE":18,"CITY":"Bejjing"}'
					model_test.read_json_file2(json_string)
				}
			}
		}
	}
}
