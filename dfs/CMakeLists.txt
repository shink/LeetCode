project(DFS)

file(GLOB DFS_SOURCES *.cpp)

foreach(source_file ${DFS_SOURCES})
    get_filename_component(exec_name ${source_file} NAME_WE)
    add_executable(dfs_${exec_name} ${source_file})
endforeach()
