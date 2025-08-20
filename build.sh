#!/bin/bash

set -ex

rm -rf build
cmake -S . -B build
cmake --build build
