project(SIMPLE)

file(GLOB LINKED_LIST_SOURCE *.cpp)

foreach(source_file ${LINKED_LIST_SOURCE})
    get_filename_component(exec_name ${source_file} NAME_WE)
    add_executable(linked_list_${exec_name} ${source_file})
    target_compile_definitions(linked_list_${exec_name} PRIVATE
        LOCAL
    )
endforeach()
