#!/bin/bash

set -ex

cmake -S . -B build
cmake --build build
