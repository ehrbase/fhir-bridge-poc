# Copyright (c) 2021 Peter Wohlfarth (Appsfactory GmbH)
#
# This file is part of Project EHRbase
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.


*** Settings ***
Resource                ${EXECDIR}/robot/_resources/suite_settings.robot

Test Setup              generic.prepare new request session    Prefer=return=representation
...															   Authorization=${AUTHORIZATION['Authorization']}
Documentation           *NOTE:* Use Regular Expressions to replace braces () as described here:
...                	    https://json-schema.org/understanding-json-schema/reference/regular_expressions.html#example \n\n
...						*Author:* Peter Wohlfarth
Force Tags              patient_create   invalid    create


*** Variables ***
${randstring}                   foobar
${randinteger}                  ${12345}
${randfloat}                    ${12.5}
${randurl}                      http://foobar.com

*** Test Cases ***

001 Create Patient (invalid/missing 'resourceType')
	[Documentation]     1. *CREATE* new an EHR record\n\n 
	...                 2. *LOAD* _create-patient-2.json_\n\n
	...                 3. *UPDATE* ``Subject - Identifier - value`` with the _UUID:_ ${subject_id} which was created in EHR record\n\n
	...                 4. *UPDATE* values for attribute ``resourceType`` \n\n
    ...                 5. *POST* example JSON to observation endpoint\n\n
	...                 6. *VALIDATE* the response status \n\n                
	[Template]		    create patient with ehr reference
    [Tags]          	resourceType

	# FIELD/PATH					VALUE							HTTP
	# 																CODE
    $.resourceType					missing							422
    $.resourceType					${randstring}					422
    $.resourceType					${EMPTY}						422
    $.resourceType					${randinteger}					422


002 Create Patient (invalid/missing 'identifier')
	[Documentation]     1. *CREATE* new an EHR record\n\n 
	...                 2. *LOAD* _create-patient-2.json_\n\n
	...                 3. *UPDATE* ``Subject - Identifier - value`` with the _UUID:_ ${subject_id} which was created in EHR record\n\n
	...                 4. *UPDATE* values for attribute ``identifier`` \n\n
    ...                 5. *POST* example JSON to observation endpoint\n\n
	...                 6. *VALIDATE* the response status \n\n                
	[Template]		    create patient w/o ehr reference
    [Tags]              identifier

	# FIELD/PATH			    VALUE					HTTP
    # invalid cases for value
    $.identifier.value		    missing					422
    $.identifier.value		    foobar					422
    $.identifier.value		    ${EMPTY}				422
    $.identifier.value		    ${{ [] }}				422
    $.identifier.value		    ${{ {} }}				422
    $.identifier.value		    ${123}					422
    
    # invalid cases for system
    $.identifier.system		    foobar					422
    $.identifier.system		    ${EMPTY}				422
    $.identifier.system		    ${{ [] }}				422
    $.identifier.system		    ${{ {} }}				422
    $.identifier.system		    ${123}					422

    # invalid cases for identifier
    $.identifier			    missing					422
    $.identifier			    ${EMPTY}				422
    $.identifier			    ${{ [] }}				422
    $.identifier			    ${{ {} }}				422
    $.identifier			    ${123}					422


003 Create Patient (invalid/missing 'extension')
	[Documentation]     1. *CREATE* new an EHR record\n\n 
	...                 2. *LOAD* _create-patient-2.json_\n\n
	...                 3. *UPDATE* ``Subject - Identifier - value`` with the _UUID:_ ${subject_id} which was created in EHR record\n\n
	...                 4. *UPDATE* values for attribute ``extension`` \n\n
    ...                 5. *POST* example JSON to observation endpoint\n\n
	...                 6. *VALIDATE* the response status \n\n                
	[Template]		    create patient with ehr reference
    [Tags]              extension

	# FIELD/PATH			                VALUE				    HTTP
    # invalid extension[0]
    $.extension[0]                          missing                 422
    $.extension[0]                          ${None}                 422
    $.extension[0]                          ${{ {} }}               422
    $.extension[0]                          ${{ [] }}               422
    $.extension[0]                          ${{ [{}] }}             422

    # invalid extension[0].url  
    $.extension[0].url                      ${randstring}           422
    $.extension[0].url                      ${empty}                422
    $.extension[0].url                      missing                 422
    $.extension[0].url                      ${randinteger}          422
    $.extension[0].url                      ${randfloat}            422
    $.extension[0].url                      ${{ {} }}               422
    $.extension[0].url                      ${randurl}              422

    # invalid extension[0].valueCoding 
    $.extension[0].valueCoding              missing	                422
    $.extension[0].valueCoding              ${None}	                422
    $.extension[0].valueCoding              ${{ {} }}               422
    $.extension[0].valueCoding              ${{ [] }}               422
    $.extension[0].valueCoding              ${{ [{}] }}             422

    # invalid extension[0].valueCoding.system
    $.extension[0].valueCoding.system       ${None}                 422
    $.extension[0].valueCoding.system       ${EMPTY}				422
    $.extension[0].valueCoding.system       ${randstring}			422
    $.extension[0].valueCoding.system       ${randinteger}			422
    $.extension[0].valueCoding.system       ${{ {} }}				422

    # invalid extension[0].valueCoding.code
    $.extension[0].valueCoding.code         ${EMPTY}				422
    $.extension[0].valueCoding.code         ${randinteger}			422
    $.extension[0].valueCoding.code         ${{ {} }}				422
    $.extension[0].valueCoding.code         ${{ [{}] }}				422
    
    #invalid extension[0].valueCoding.display
    $.extension[0].valueCoding.display      ${EMPTY}				422
    $.extension[0].valueCoding.display      ${randinteger}			422
    $.extension[0].valueCoding.display      ${{ {} }}				422
    $.extension[0].valueCoding.display      ${{ [{}] }}				422   

    # invalid extension[1]
    # $.extension[1]                          missing	                422
    # see Bug Trace 01
    $.extension[1]                          ${None}	                422
    $.extension[1]                          ${{ {} }}               422
    $.extension[1]                          ${{ [] }}               422
    $.extension[1]                          ${{ [{}] }}	            422
    
    # invalid extension[1].url
    $.extension[1].url                      ${randstring}           422
    $.extension[1].url                      ${empty}                422
    $.extension[1].url                      missing                 422
    $.extension[1].url                      ${randinteger}          422
    $.extension[1].url                      ${randfloat}            422
    $.extension[1].url                      ${{ {} }}               422
    # $.extension[1].url                      ${randurl}              422
    # see Bug Trace 01

    # invalid extension[1].extension[0]
    $.extension[1].extension[0]             missing                 422
    $.extension[1].extension[0]             ${None}                 422
    $.extension[1].extension[0]             ${{ {} }}               422
    $.extension[1].extension[0]             ${{ [] }}               422

    # invalid extension[1].extension[0].url
    $.extension[1].extension[0].url         ${randstring}           422
    $.extension[1].extension[0].url         ${empty}                422
    $.extension[1].extension[0].url         missing                 422
    $.extension[1].extension[0].url         ${randinteger}          422
    $.extension[1].extension[0].url         ${randfloat}            422
    $.extension[1].extension[0].url         ${{ {} }}               422
    $.extension[1].extension[0].url         ${randurl}              422


    # invalid extension[1].extension[0].valueDateTime
    $.extension[1].extension[0].valueDateTime             missing					422
    $.extension[1].extension[0].valueDateTime             ${EMPTY}				    422
    $.extension[1].extension[0].valueDateTime             ${{ [] }}				    422
    $.extension[1].extension[0].valueDateTime             ${{ {} }}				    422
    $.extension[1].extension[0].valueDateTime             ${{ [{}] }}				422
    $.extension[1].extension[0].valueDateTime             2020-09-00				422
    $.extension[1].extension[0].valueDateTime             2020-09-32				422
    $.extension[1].extension[0].valueDateTime             2020-09-dd				422
    $.extension[1].extension[0].valueDateTime             2020-00-21				422
    $.extension[1].extension[0].valueDateTime             2020-13-21				422
    $.extension[1].extension[0].valueDateTime             2020-mm-21				422
    $.extension[1].extension[0].valueDateTime             0000-09-21				422
    $.extension[1].extension[0].valueDateTime             10000-09-21				422
    $.extension[1].extension[0].valueDateTime             yyyy-09-21				422
    $.extension[1].extension[0].valueDateTime             21.09.2020				422
    $.extension[1].extension[0].valueDateTime             ${randstring}			    422
    $.extension[1].extension[0].valueDateTime             ${randinteger}			422

    # invalid extension[1].extension[1]
    $.extension[1].extension[1]             missing	                422
    $.extension[1].extension[1]             ${None}	                422
    $.extension[1].extension[1]             ${{ {} }}               422
    $.extension[1].extension[1]             ${{ [] }}               422
    
    # invalid extension[1].extension[1].url
    $.extension[1].extension[1].url         ${randstring}           422
    $.extension[1].extension[1].url         ${empty}                422
    $.extension[1].extension[1].url         missing                 422
    $.extension[1].extension[1].url         ${randinteger}          422
    $.extension[1].extension[1].url         ${randfloat}            422
    $.extension[1].extension[1].url         ${{ {} }}               422
    $.extension[1].extension[1].url         ${randurl}              422

    # invalid extension[1].extension[1].valueAge
    $.extension[1].extension[1].valueAge    missing	                422
    $.extension[1].extension[1].valueAge    ${None}	                422
    $.extension[1].extension[1].valueAge    ${{ {} }}               422
    $.extension[1].extension[1].valueAge    ${{ [] }}               422

    # invalid extension[1].extension[1].valueAge.value
    
    # $.extension[1].extension[1].valueAge.value          missing             422
    # see Bug Trace 02
    $.extension[1].extension[1].valueAge.value          ${EMPTY}            422
    $.extension[1].extension[1].valueAge.value          ${None}             422
    $.extension[1].extension[1].valueAge.value          ${-1}               422
    $.extension[1].extension[1].valueAge.value          ${randstring}       422

    # invalid extension[1].extension[1].valueAge.unit
    
    $.extension[1].extension[1].valueAge.unit           ${EMPTY}            422
    $.extension[1].extension[1].valueAge.unit           ${None}		        422
    $.extension[1].extension[1].valueAge.unit           ${123}              422

    # invalid extension[1].extension[1].valueAge.system
    
    $.extension[1].extension[1].valueAge.system         missing             422  
    $.extension[1].extension[1].valueAge.system         ${None}		        422
    $.extension[1].extension[1].valueAge.system         ${EMPTY}	        422
    $.extension[1].extension[1].valueAge.system         ${randinteger}      422
    $.extension[1].extension[1].valueAge.system         ${randstring}		422

    # invalid extension[1].extension[1].valueAge.code
    
    $.extension[1].extension[1].valueAge.code           missing             422 
    $.extension[1].extension[1].valueAge.code           ${EMPTY}	        422
    $.extension[1].extension[1].valueAge.code           ${None}		        422
    $.extension[1].extension[1].valueAge.code           ${123}		        422


#--------------------------------------------------------------------------------------------------------------------------------------------------------------------
# BUG TRACE
#--------------------------------------------------------------------------------------------------------------------------------------------------------------------
BUG TRACE 01 Create Patient (Invalid/Missing 'extension')
	[Documentation]		Belongs to TC 003! Remove separation when it's fixed!
	[Template]			create patient with ehr reference
    [Tags]              extension    not-ready    not-ready_bug    281

    # FIELD/PATH							            VALUE					HTTP
	# 																            CODE
    # invalid extension[1]
    #$.extension[1]                                      missing	                422
    # this is not an invalid thing, since it is removing the 'age' extension which is optional in the profile, so it should be accepted
    $.extension[1]                                      missing	                201

    # invalid extension[1].url
    $.extension[1].url                                  ${randurl}              422
    [Teardown]  TRACE GITHUB ISSUE  281



BUG TRACE 02 Create Patient (Invalid/Missing 'extension')
	[Documentation]		Belongs to TC 003! Remove separation when it's fixed!
	[Template]			create patient with ehr reference
    [Tags]              extension    not-ready    not-ready_bug    282

    # FIELD/PATH							            VALUE					HTTP
	# 																            CODE
    # invalid extension[1].extension[1].valueAge.value
    $.extension[1].extension[1].valueAge.value          missing                 422
    [Teardown]  TRACE GITHUB ISSUE  282
    
 





*** Keywords ***

# oooo    oooo oooooooooooo oooooo   oooo oooooo   oooooo     oooo   .oooooo.   ooooooooo.   oooooooooo.    .oooooo..o
# `888   .8P'  `888'     `8  `888.   .8'   `888.    `888.     .8'   d8P'  `Y8b  `888   `Y88. `888'   `Y8b  d8P'    `Y8
#  888  d8'     888           `888. .8'     `888.   .8888.   .8'   888      888  888   .d88'  888      888 Y88bo.
#  88888[       888oooo8       `888.8'       `888  .8'`888. .8'    888      888  888ooo88P'   888      888  `"Y8888o.
#  888`88b.     888    "        `888'         `888.8'  `888.8'     888      888  888`88b.     888      888      `"Y88b
#  888  `88b.   888       o      888           `888'    `888'      `88b    d88'  888  `88b.   888     d88' oo     .d8P
# o888o  o888o o888ooooood8     o888o           `8'      `8'        `Y8bood8P'  o888o  o888o o888bood8P'   8""88888P'
#
# [ HIGH LEVEL KEYWORDS ]



create patient with ehr reference
	[Arguments]         ${json_path}        ${value}                 ${http_status_code}

						ehr.create new ehr                      000_ehr_status.json
	${payload}=    		generate payload from example json      ${json_path}    ${value}
						Patient.POST /patient  				patient  ${payload}          	
						patient.validate response - 422 (w/o error message)  ${http_status_code}



create patient w/o ehr reference    
	[Arguments]         ${json_path}        ${value}                ${http_status_code}

	${fake_ehr_ref}=	Evaluate    str(uuid.uuid4())    uuid
						Set Test Variable    ${subject_id}    ${fake_ehr_ref}
	${payload}=    		generate payload from example json      ${json_path}    ${value}
						Patient.POST /patient  				patient  ${payload}          	
						patient.validate response - 422 (w/o error message)  ${http_status_code}															      


generate payload from example json
	[Documentation]		Generates actual request payload using example json as a starting point.
	[Arguments]			${json_path}    ${value}

	${payload}          Load JSON From File    ${DATA_SET_PATH_PATIENT}/create-patient-2.json
                        Update Value To Json    ${payload}    $.identifier[0].value    ${subject_id}
						Delete Object From Json    ${payload}    $.text

						# comment: delete field/object that has value 'missing' in test case table 
						Run Keyword And Return If   $value=="missing"
						...    	Run Keyword    Delete Object From Json    ${payload}    ${json_path}

						# comment: set value from data table in test case
						Update Value To Json            ${payload}    ${json_path}    ${value}
						Output Debug Info To Console    ${payload}

	[Return]			${payload}