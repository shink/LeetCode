project(BFS)

file(GLOB BFS_SOURCES *.cpp)

foreach(source_file ${BFS_SOURCES})
    get_filename_component(exec_name ${source_file} NAME_WE)
    add_executable(bfs_${exec_name} ${source_file})
endforeach()
