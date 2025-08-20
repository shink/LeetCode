cmake_minimum_required(VERSION 3.10)
project(LEETCODE_SOLUTIONS)

set(CMAKE_EXPORT_COMPILE_COMMANDS ON)
set(CMAKE_CXX_STANDARD 17)

# 模板
add_subdirectory(template)

# 动态规划
add_subdirectory(dp)

# 链表
add_subdirectory(linked_list)
