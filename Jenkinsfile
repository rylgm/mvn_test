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
		stage("write json"){
			steps{
				script{
					json_file = env.WORKSPACE + "/testdata/test_json.json"
					output_file = env.WORKSPACE + "/test/data/new_json.json"
					model_test.write_json_to_file(json_file, output_file)
					println "============================================="
					json_string = '{"NAME": "Tom", "AGE": 18, "CITY": "Beijing"}'
					tojson_file = env.WORKSPACE + "/testdata/new_json1.json"
					model_test.write_json_to_file(json_string, tojson_file)
				}
			}
		}
	}
}
