# PlatON-Tests

### Test execution

1. Dependent installation 

```js
pip install -r requirements.txt
```

2. Execute the test

Follow the pytest command to execute, add a new parameter reference[conftest.py](../conftest.py)。

example: 

```js
pytest 'tests/chain/test_chain_deploy.py' --nodeFile "deploy/node/test_chaininfo.yml" --accountFile "deploy/accounts.yml"
```

More please check[readme](../README.md)

Remarks:
There are many combinations of project management and execution test commands. 
You need to input a large number of commands and consider introducing a Makefile.

### Project structure description

1. Root directory:

+ pytest.ini pytestTest the configuration file. For details, please refer to the official file.
[pytest.ini](https://docs.pytest.org/en/latest/reference.html#configuration-options)。

+ conftest.py-pytestPlug-ins, mainly including the introduction of command line parameters, 
test environment generation, test failure use case log download and other functions.

2.common：

+ Project public methods, including logging, configuration file reading, connecting to linux server, 
establishing web3 connection, binary package download, etc.

3.conf：

+ Local file path configuration when deploying the environment, please see the file notes for details.

4.deploy：

+ Deployment file storage path, used with conf

5.environment：

+ Deployment environment script, consisting of five classes: TestConfig, TestEnvironment, Account, Server, Node。
+ TestConfig: Deployment environment configuration, test environment global configuration。
+ Account: Test account management class for testing, account generation, transfer, etc.。
+ Server: Server management class for deployment, management server dependencies, and compressed file management.
+ TestEnvironment: Test environment class, used to manage the test environment, start the node, close the node, restart the node, get the node, get the account, and so on.
+ Node: Node class, used to manage nodes, with basic node information, node connections, node running status, node start and stop, and so on.

6.tests：

+ Use case storage directory

7.tests/lib:

+ Utils: use case public method
+ Configuration: StakingConfig, pledge basic configuration; PipConfig, pip basic configuration; DefaultEconomicConfig economic model basic configuration
+ genesi：Genesis Genesis.json file convertible object
+ The rest of the classes are secondary packages for sdk


### Example

[staking example](../tests/example/test_staking.py)

[Custom node deployment](../tests/example/test_customize_deploy.py)

### Feature description

+ Abandon the deployment form in the old framework, introduce test environment objects and node objects, used to manage the test environment and nodes, including a large number of node attributes in the node, eliminating the need to retrieve a large number of node information

+ The w3 connection establishment introduces a timeout mechanism to avoid the problem that the node just starts to connect and causes an error.

+ Remove the setup, introduce the fixture, design the use case, the common steps need to be designed as a step method, remove the duplicate step code

+ Deployment optimization, sacrificing environment preparation time, and greatly improving the speed of secondary deployment


# PlatON-Tests
This is an automated test project of the PaltON-Go

## Install
Install the python 3.7 environment and configure pip, then execute the following command to install the dependency library:
```shell script
pip install -r requirements.txt
```

## Run

### Execute all test cases

```shell script
pytest test_start.py --nodeFile "deploy/4_node.yml" --accountFile "deploy/accounts.yml" --initChain
```

### Execute at Multiple environment

```shell script
pytest "case_path" --nodeFile "node_file_1,node_file_2" --accountFile "deploy/accounts.yml" --initChain -n 2
```

Note: The number of node configuration files must be equal to the number of threads, and multiple node configuration files are separated by English ","

## pytest Command line argument

--nodeFile "deploy/node.yml": Specify the node configuration file

--accountFile "deploy/accounts.yml": Specify the account file for testing

--installDependency：Indicates that the node needs to install the required dependencies, which is generally used during the first deployment; if it is not, it is no longer installed.

--installSuperVisor：Indicates whether the node is installed with the supervisor service. It is usually used for the first deployment. If you do not have this option, it is no longer installed.

## Precautions
Currently only supports Ubuntu environment deployment
File storage requirements:
    Accounts.yml file, put in the deploy directory, platon binary file into deploy/bin, nodeFile into deploy/node
    Other files, put in the deploy/template template directory

### test case example:
```python
import pytest
@pytest.mark.P1
def test_case_001():
    print("begin: test_case_001")
    SomeTxAPI("test_case_001")
    print("end: test_case_001")
```

