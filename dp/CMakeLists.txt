project(DP)

file(GLOB DP_SOURCES *.cpp)

foreach(source_file ${DP_SOURCES})
    get_filename_component(exec_name ${source_file} NAME_WE)
    add_executable(dp_${exec_name} ${source_file})
endforeach()
