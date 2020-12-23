
.PHONY: clean-pyc clean-tmp

help:
	@echo "install - install requirements.txt python lib"
	@echo "test - run tests quickly with the default Python"
	@echo "lint - check style with autopep8"
	@echo "clean - remove run tmp"


install:
	pip3 install -r requirements.txt


test:
	py.test --tb native tests


clean:
	rm -rf ./report +
	rm -rf ./log +
	rm -rf ./bug_log +
	rm -rf ./allure-report +
	rm -rf ./.pytest_cache +
	rm -rf ./deploy/tmp +


lint:
	find . -name '*.py' -exec autopep8  --max-line-length=180 --in-place --aggressive --ignore=E123,E133,E50 {} +


clean-pyc:
	find . -name '*.pyc' -exec rm -f {} +
	find . -name '*.pyo' -exec rm -f {} +
	find . -name '*~' -exec rm -f {} +
	find . -name '__pycache__' -exec rm -rf {} +
