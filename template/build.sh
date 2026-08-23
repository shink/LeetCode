#!/bin/bash

set -ex

rm -rf bin/*
mkdir -p bin
g++ -o bin/main --std=c++17 -Wall -Wextra -DLOCAL main.cpp

./bin/main
