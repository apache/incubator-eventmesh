(window.webpackJsonp=window.webpackJsonp||[]).push([[17],{323:function(t,s,e){t.exports=e.p+"assets/img/project-structure.66101692.png"},396:function(t,s,e){"use strict";e.r(s);var a=e(42),n=Object(a.a)({},(function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("ContentSlotsDistributor",{attrs:{"slot-key":t.$parent.slotKey}},[a("h1",[t._v("Eventmesh-runtime快速入门说明")]),t._v(" "),a("h2",{attrs:{id:"_1-远程部署"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#_1-远程部署"}},[t._v("#")]),t._v(" 1 远程部署")]),t._v(" "),a("h3",{attrs:{id:"_1-1-依赖"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#_1-1-依赖"}},[t._v("#")]),t._v(" 1.1 依赖")]),t._v(" "),a("div",{staticClass:"language- extra-class"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[t._v("建议使用64位操作系统，建议使用Linux / Unix；\n64位JDK 1.8+;\nGradle至少为5.6, 推荐 5.6.*\n")])])]),a("h3",{attrs:{id:"_1-2-下载源码"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#_1-2-下载源码"}},[t._v("#")]),t._v(" 1.2 下载源码")]),t._v(" "),a("p",[a("a",{attrs:{href:"https://github.com/WeBankFinTech/EventMesh",target:"_blank",rel:"noopener noreferrer"}},[t._v("https://github.com/WeBankFinTech/EventMesh"),a("OutboundLink")],1),t._v("\n您将获得"),a("strong",[t._v("EventMesh-master.zip")])]),t._v(" "),a("h3",{attrs:{id:"_1-3-构建源码"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#_1-3-构建源码"}},[t._v("#")]),t._v(" 1.3 构建源码")]),t._v(" "),a("div",{staticClass:"language-$ xslt extra-class"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[t._v("unzip EventMesh-master.zip\ncd / *您的部署路径* /EventMesh-master/eventmesh-runtime\ngradle clean dist tar -x test\n")])])]),a("p",[t._v("您将在目录/ "),a("em",[t._v("您的部署路径")]),t._v(" /EventMesh-master/eventmesh-runtime/dist中获得"),a("strong",[t._v("eventmesh-runtime_1.0.0.tar.gz")])]),t._v(" "),a("h3",{attrs:{id:"_1-4-部署"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#_1-4-部署"}},[t._v("#")]),t._v(" 1.4 部署")]),t._v(" "),a("ul",[a("li",[t._v("部署eventmesh-runtime")])]),t._v(" "),a("div",{staticClass:"language-$ xslt extra-class"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[t._v("upload eventmesh-runtime_1.0.0.tar.gz\ntar -zxvf eventmesh-runtime_1.0.0.tar.gz\ncd bin\n配置 proxy.properties\ncd ../bin\nsh start.sh\n")])])]),a("p",[t._v('如果看到"ProxyTCPServer[port=10000] started...."，则说明设置成功。')]),t._v(" "),a("h2",{attrs:{id:"_2-本地构建运行"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#_2-本地构建运行"}},[t._v("#")]),t._v(" 2 本地构建运行")]),t._v(" "),a("h3",{attrs:{id:"_2-1-依赖"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#_2-1-依赖"}},[t._v("#")]),t._v(" 2.1 依赖")]),t._v(" "),a("p",[t._v("同上述步骤 1.1")]),t._v(" "),a("h3",{attrs:{id:"_2-2-下载源码"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#_2-2-下载源码"}},[t._v("#")]),t._v(" 2.2 下载源码")]),t._v(" "),a("p",[t._v("同上述步骤 1.2")]),t._v(" "),a("h3",{attrs:{id:"_2-3-本地启动"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#_2-3-本地启动"}},[t._v("#")]),t._v(" 2.3 本地启动")]),t._v(" "),a("p",[a("strong",[t._v("2.3.1 项目结构说明：")])]),t._v(" "),a("p",[a("img",{attrs:{src:e(323),alt:""}})]),t._v(" "),a("ul",[a("li",[t._v("eventmesh-common : eventmesh公共类与方法模块")]),t._v(" "),a("li",[t._v("eventmesh-connector-api : eventmesh插件接口定义模块")]),t._v(" "),a("li",[t._v("eventmesh-connector-rocketmq : eventmesh rocketmq插件模块")]),t._v(" "),a("li",[t._v("eventmesh-runtime : eventmesh运行时模块")]),t._v(" "),a("li",[t._v("eventmesh-sdk-java : eventmesh java客户端sdk")]),t._v(" "),a("li",[t._v("eventmesh-starter : eventmesh本地启动运行项目入口")])]),t._v(" "),a("blockquote",[a("p",[t._v("注：插件模块遵循java spi机制，需要在对应模块中的/main/resources/META-INF/services 下配置相关接口与实现类的映射文件")])]),t._v(" "),a("p",[a("strong",[t._v("2.3.2 配置VM启动参数")])]),t._v(" "),a("div",{staticClass:"language-java extra-class"},[a("pre",{pre:!0,attrs:{class:"language-java"}},[a("code",[a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("-")]),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("Dlog4j")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("configurationFile"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("\\eventmesh"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("-")]),t._v("runtime\\conf\\log4j2"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("xml\n"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("-")]),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("Dproxy")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("log"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("home"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("\\eventmesh"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("-")]),t._v("runtime\\logs\n"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("-")]),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("Dproxy")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("home"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("\\eventmesh"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("-")]),t._v("runtime\n"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("-")]),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("DconfPath")]),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("\\eventmesh"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("-")]),t._v("runtime\\conf\n")])])]),a("p",[a("strong",[t._v("2.3.3 配置build.gradle文件")])]),t._v(" "),a("p",[t._v("通过修改dependencies，compile project 项来指定项目启动后加载的插件")]),t._v(" "),a("p",[t._v("修改"),a("code",[t._v("eventmesh-starter")]),t._v("模块下面的"),a("code",[t._v("build.gradle")]),t._v("文件")]),t._v(" "),a("p",[t._v("加载"),a("strong",[t._v("RocketMQ")]),t._v("插件配置：")]),t._v(" "),a("div",{staticClass:"language-java extra-class"},[a("pre",{pre:!0,attrs:{class:"language-java"}},[a("code",[t._v("dependencies "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n    compile "),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("project")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token string"}},[t._v('":eventmesh-runtime"')]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("project")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token string"}},[t._v('":eventmesh-connector-rocketmq"')]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),t._v("\n"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),t._v("\n")])])]),a("p",[a("strong",[t._v("2.3.4 启动运行")])]),t._v(" "),a("div",{staticClass:"language- extra-class"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[t._v("运行com.webank.eventmesh.starter.StartUp的主要方法\n")])])])])}),[],!1,null,null,null);s.default=n.exports}}]);