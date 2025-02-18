# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

include_directories(src/main/cpp/include)
# 编译源文件
#file(GLOB my_source_path src/main/cpp/*.cpp src/main/cpp/*.c)
aux_source_directory(${CMAKE_SOURCE_DIR}/src/main/cpp my_source_path)
aux_source_directory(${CMAKE_SOURCE_DIR}/src/main/cpp/bzip2 SOURCES)





add_library(native-lib SHARED ${my_source_path} ${SOURCES} )



# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.
add_library(lib_opencv SHARED IMPORTED)

#add_library( # Sets the name of the library.
#        native-lib
#
#        # Sets the library as a shared library.
#        SHARED IMPORTED
#
#        # Provides a relative path to your source file(s).
#        src/main/cpp/native-lib.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)
set_target_properties(lib_opencv
        PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/src/main/jni/${ANDROID_ABI}/libopencv_java3.so)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        native-lib

        log
        jnigraphics
        lib_opencv
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib}
        )

# 调试用 set 函数 可以调优设置
# 开启输出详细的编译和链接信息
set(CMAKE_VERBOSE_MAKEFILE on)
message("zcw before")

message(STATUS ${SOURCES})

message(STATUS "zcw after")