/*
앱 개발 시 테스트 진행 or 개발 완료 후 사용자에게 배포 : 빌드 작업 필요
그레이들 Gradle : 앱에 포함된 리소스, 자바 코드를 컴파일 / 준비된 키로 서명 => 배포용 APK 파일 추출하는 도구
	build.gradle 파일에서 그레이들 관련 설정 가능 (GradleScripts 영역)
	프로젝트 수준과 모듈 수준으로 구분

	프로젝트 수준 : 전체 프로젝트를 위한 설정
	모듈 수준 : 각 모듈을 위한 설정 파일
		모듈 하나당 하나의 그레이들 파일*/

//        1. settings.gradle
//        	그레이들에 모듈 포함 => 그레이들이 모듈 관리 및 빌드하도록 설정하는 파일
//        	settings.gradle 파일 오픈 시 그레이들이 관리하고 빌드해야 하는 모듈이 등록되어 있음
	    include ':app' // app이라는 모듈 하나만 등록
//        	자동으로 등록되므로 개발자가 직접 조정할 일 적음

//        2. 프로젝트 수준의 그레이들
//        	Gradle Scripts 영역 최상단 위치한 build.gradle ( 옆에 프로젝트명 표시된 파일 )
//	        모든 모듈을 위한 최상위 설정에 목적
        buildscript{
            repositories{
                google()
                jcenter()
            }
            dependencies{
                classpath 'com.android.tools.build:gradle:3.3.2'
            }
        }
        allprojects{
            repositories{
                google()
                jcenter()
            }
        }
        task clean(type: Delete){
            delete rootProject.buildDir
        }
//          대부분 모듈 수준의 그레이들이 자주 이루어짐 => 프로젝트 수준의 그레이들 파일 설정은 빈번하지 X
//          설정 시 dependencies 부분에 라이브러리 추가 정도

//      3.  모듈 수준의 그레이들
        apply plugin: 'com.android.application'
        android{
            compileSdkVersion 28
            defaultConfig{
                applicationId "com.example.user.androidlab"
                minSdkVersion 15
                targetSdkVersion 28
                versionCode 1
                versionName "1.0"
                testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
            }
            buildTypes{
                release{
                    minifyEnabled false
                    proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
                }
            }
        }
        dependencies{
            implementation fileTree(dir: 'libs', include: ['*.jar'])
            implementation 'com.android.support:appcompat-v7:28.0.0'
            implementation 'com.android.support.constraint:constraint-layout:1.1.3'
            testImplementation 'junit:junit:4.12'
            androidTestImplementation 'com.android.support.test:runner:1.0.2'
            androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
        }
//          모듈 수준의 그레이들 파일의 설정은 모듈 개발 및 빌드에 중요한 역할

//          compileSdkVersion : 사용 컴파일러의 버전
//          applicatioinId "com.example.user.androidlab' : 앱의 식별자 // applicationID 속성으로 지정한 문자열로 식별
//          minSdkVersion : 최소 지원 범위
//          targetSdkVersion : 사용중인 SDK 버전 // 대부분 개발 시점의 최신 버전 지정
//          versionCode : 앱의 버전
//          dependencies : 외부 라이브러리의 등록처