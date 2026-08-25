cmake_minimum_required(VERSION 3.30)

project(Coursework C)

set(CMAKE_C_STANDARD 23)
set(CMAKE_C_STANDARD_REQUIRED ON)

add_compile_options(-Wno-implicit-int)

file(GLOB_RECURSE C_SOURCES CONFIGURE_DEPENDS
    "${CMAKE_SOURCE_DIR}/*.c"
)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY "${CMAKE_BINARY_DIR}/bin")

set(SOURCE_INDEX 0)

foreach(SOURCE_FILE IN LISTS C_SOURCES)

    math(EXPR SOURCE_INDEX "${SOURCE_INDEX} + 1")

    file(RELATIVE_PATH RELATIVE_SOURCE
        "${CMAKE_SOURCE_DIR}"
        "${SOURCE_FILE}"
    )

    get_filename_component(SOURCE_NAME "${SOURCE_FILE}" NAME_WE)

    set(OUTPUT_NAME "${SOURCE_NAME}")

    if(RELATIVE_SOURCE MATCHES "^(Лабораторни упражнения|Семинарни упражнения)[/\\\\]Седмица - ([0-9]+)[/\\\\]([0-9]+)\\. (.+)\\.c$")

        set(EXERCISE_TYPE "${CMAKE_MATCH_1}")
        set(WEEK "${CMAKE_MATCH_2}")
        set(TASK_NUMBER "${CMAKE_MATCH_3}")
        set(TASK_NAME "${CMAKE_MATCH_4}")

        if(EXERCISE_TYPE STREQUAL "Лабораторни упражнения")
            set(PREFIX "lab")
        else()
            set(PREFIX "sem")
        endif()

        set(OUTPUT_NAME
            "${PREFIX}_${WEEK}_${TASK_NUMBER}. ${TASK_NAME}"
        )

    endif()

    set(TARGET_NAME "program_${SOURCE_INDEX}")

    add_executable("${TARGET_NAME}" "${SOURCE_FILE}")

    set_target_properties("${TARGET_NAME}" PROPERTIES
        OUTPUT_NAME "${OUTPUT_NAME}"
    )

endforeach()