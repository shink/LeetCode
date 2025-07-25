project(SIMPLE)

file(GLOB SIMPLE_SOURCES *.cpp)

foreach(source_file ${SIMPLE_SOURCES})
    get_filename_component(exec_name ${source_file} NAME_WE)
    add_executable(simple_${exec_name} ${source_file})
endforeach()
