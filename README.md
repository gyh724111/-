# ComputerApplicationHomeWorkAndroid
# ComputerApplicationHomeWorkAndroid

---

1、由于没有部署域名，所以需要先绑定服务器ip

resume为个人简介项目服务端
https://github.com/gyh724111/ComputerApplicationHomeWorkServer

resumeapp本项目为个人简介项目客户端

---

2、调用服务端接口获取简历列表

>${ip:port}/user/listall

获取用户列表


![image](https://i0.hdslb.com/bfs/sycp/mgk/img/202211/75a081aadee2fffe52ae8687733b86c4.png)


![image](https://i0.hdslb.com/bfs/sycp/mgk/img/202211/f6f72d16be64567ef9c3a5bf1dc1c3c6.png)

服务端完整数据
```
[
    {
        "id": 1,
        "name": "葛永晖",
        "job": "资深测试工程师",
        "sex": 1,
        "birth": "1995-07-24",
        "tel": "17621778276",
        "desc": "5年工作经验",
        "mail": "397910995@qq.com",
        "type": "0"
    },
    {
        "id": 2,
        "name": "李姝",
        "job": "规划师",
        "sex": 2,
        "birth": "1995-04-19",
        "tel": "15021974266",
        "desc": "公务员",
        "mail": "xxxxxxx@qq.com",
        "type": "0"
    }
]
```

---

3、调用服务端用户详情接口获取用户详细信息

>${ip:port}/user/getuserdetail/${userid}

 <img width="360" alt="image" src="https://i0.hdslb.com/bfs/sycp/mgk/img/202211/b1ffdeea282a7885c0a20851d07039c7.png">

 
![image](https://i0.hdslb.com/bfs/sycp/mgk/img/202211/ebd2e31a2825186105e01d14dfcb7e92.png)

服务端完整数据
```
{
    "user": {
        "id": 1,
        "name": "葛永晖",
        "job": "资深测试工程师",
        "sex": 1,
        "birth": "1995-07-24",
        "tel": "17621778276",
        "desc": "5年工作经验",
        "mail": "397910995@qq.com",
        "type": "0"
    },
    "desc": {
        "id": 1,
        "user_id": 1,
        "desc_detail": "1.掌握软件测试理论及高效高覆盖率的用例编写，掌握MacOS、Linux，shell使用 \n2. 5年移动端服务端业务测试经验，熟练掌握针对智能广告推荐、效果广告、品牌广告、商业带货、up主个人营销、在线点单 结算等系统的端到端全链路测试 \n3.熟悉常见数据库使用，工作中使用sqlite、MySQL、redis、hive等 \n4.掌握接口自动化，使用testng、jacoco等编写，掌握postman、jmeter等工具 "
    },
    "workExp": [
        {
            "id": 1,
            "user_id": 1,
            "org_name": "美味不用等（上海）信息科技股份有限公司",
            "seq": 1,
            "type": 0,
            "exp": "内容：\n 1、负责开发自动化测试工具，并持续适配新版本进行部署；\n 2、编写脚本快速定位线上客户问题 \n3、定位生产环境大客户问题； \n4、负责QA部和其他部门技术对接； \n5、制定版本发布计划，组织版本灰度评审； \n6、负责为黑盒测试人员设计数据测试案例，指导测试部了解产品软件架构，．\n7、协助其他部门了解生产环境需求，开发运维工具等。",
            "title": "QA工程师",
            "duration": "2017.7~2018.9"
        },
        {
            "id": 2,
            "user_id": 1,
            "org_name": "上海哔哩哔哩科技有限公司",
            "seq": 2,
            "type": 0,
            "exp": "内容: \n1、参与产品需求评审制定测试计划，熟练掌握广告变现逻辑，熟练掌握广告cpc、cpm、cpt、gd等售卖模式，掌握ocpx出价 模式，在需求前期提出提升ctr的建议以及风控风险，且考虑用户体验性 \n2、熟练掌握业务架构，参与技术评审，与开发—起制定技术方案 \n3、参与服务端开发测试，APP测试，并且负责带领app测试组，完成任务分配以及保证迭代质量 \n4、所有端到端需求指导投放服务端、策略引擎服务端、APP测试同事测试点，组织用例联调，作为接口人推进和其他部门联调\n5、APP等C端系统业务全链路测试 \n6、APP ui埋点自动化＆接口自动化覆盖（APP 600+ 接口200+） \n7、保证广告检索系统全链路上线质量，包括服务端索引数据，检索逻辑，app展示交互以及埋点，回传归因数据链路正确， 及时线上问题调查处理 \n8、多次公开培训新入职产品、技术关于部门业务链路逻辑。 \n\n业绩: \n● 作为公线人员，负责商业技术9条业务线所有端到端业务需求测试跟进，包含效果广告、品牌广告、up主营销、带货等 \n● 多场景广告全链路测试、包含且不限于首页信息流、banner、播放详情页推荐、播放页框内弹幕浮层、竖版视频页、搜 索、分区首页中插、小程序、各类sdk集成、web广告等 \n● 熟练掌握各类广告数据链路测试逻辑，包含且不限于唤起、下载、激活、付费、店铺吊起、涨粉等归因方式 \n● 在测试部中带领APP测试团队，期间完成发版速度从3周加快至1周的模式转变，并指导投放系统以及检索系统测试端到端 需求关键测试点，组织并推进用例评审和多部门联调 \n● 数十个商业系统上线，多次618、双十一、风控GR紧急需求跟进 \n● 提升APP埋点自动化效率",
            "title": "资深自动化测试工程师",
            "duration": "2018.9~至今"
        }
    ],
    "projectExp": [
        {
            "id": 3,
            "user_id": 1,
            "org_name": "美易点（全能版）",
            "seq": 1,
            "type": 1,
            "exp": "内容：\n1、美味美易点（全能版）saas收银系统，包含web端，手机端，以及pos机；对接新美大、饿了么、微信以及第三方支付平 台，提供模块化可定制的快餐、正餐以及外卖收银功能。 \n2、负责功能测试、自动化测试落地、数据测试、生产环境问题调查，以及指导手工测试同事用例设计，代表部门与其他部门对接。",
            "title": "全栈测试",
            "duration": "2017.7~2018.9"
        },
        {
            "id": 4,
            "user_id": 1,
            "org_name": "商业广告智能推荐系统",
            "seq": 2,
            "type": 1,
            "exp": "内容： \n1、利用服务端智能推荐，智能出价，提高转化，经过AI分流和网关封装，到app展示上报服务端归因，形成闭环数据链路。 包含不限于效果广告、品牌广告、up主起飞广告、各类C端B端管理工具和页面制作工具等。 \n2、负责端到端需求中从投放到推荐引擎下发以及app展示和上报归因的全链路测试 \n3、带领app和服务端测试团队完成迭代速度3周到1周的加速",
            "title": "全栈测试",
            "duration": "2018.9~至今"
        },
        {
            "id": 5,
            "user_id": 1,
            "org_name": "up主带货系统",
            "seq": 3,
            "type": 1,
            "exp": "内容： \n1、为视频创作者提供更多变现方式，达到持续创作的目的;提供包括商单、弹幕浮层橱窗带货、流量推广等方式 \n2、广告主投放广告可以任意出在视频创作者开通权限的位置，或者视频创作者主动选择广告出现时机，和视频内容相结合 \n3、广告主直接打款到视频创作者账号",
            "title": "全栈测试",
            "duration": "2018.9~至今"
        },
        {
            "id": 6,
            "user_id": 1,
            "org_name": "商业广告基于mock的APP埋点自动化",
            "seq": 4,
            "type": 1,
            "exp": "内容： \n● 基于广告下发的随机性，为满足app自动化测试效率故使用可编程代理工具mock拦截、制造各个页面的广告数据让APP展示\n● 集成抓包工具和ui自动化工具，校验页面UI和上报埋点关键参数 \n● 随着APP业务需求和技术需求迭代，持续覆盖迭代，例如适配gRPC改造 \n● 集成jacoco XcodeCoverage进行自动化测试代码覆盖率统计 \n业绩： \n● 考虑人工跑case的数据准备、mock、校验时间、单次运行600+条case可节省150小时 \n● 通过自动化case编写提高双端一致性 \n● 多次在APP全公司合入总包验证期间发现严重bug \n● 已申请专利",
            "title": "测试开发",
            "duration": "2018.9~至今"
        }
    ],
    "studyExp": [
        {
            "id": 8,
            "user_id": 1,
            "org_name": "上海海事大学",
            "seq": 1,
            "type": 3,
            "exp": "网络工程",
            "title": "本科",
            "duration": "2013~2017"
        },
        {
            "id": 9,
            "user_id": 1,
            "org_name": "复旦大学",
            "seq": 2,
            "type": 3,
            "exp": "项目管理",
            "title": "硕士",
            "duration": "2021~2024"
        }
    ],
    "practiceExp": [
        {
            "id": 7,
            "user_id": 1,
            "org_name": "上海来客之家网络有限公司",
            "seq": 0,
            "type": 2,
            "exp": "内容： 1、完成商品从服务端入库到下发到pos机点单的全流程端到端测试 2、完成线上问题跟踪查日志，并且编写线上问题检测脚本 3、完成新系统线下实施等对接工作 4、完成pos机下单、打印机打印以及数据多设备同步自动化测试从无到有部署",
            "title": "QA工程师",
            "duration": "2016.07~2017.07"
        }
    ],
    "hobby": [
        {
            "id": 1,
            "user_id": 1,
            "hobby": "耳机"
        },
        {
            "id": 2,
            "user_id": 1,
            "hobby": "手机电子产品"
        }
    ],
    "honor": [
        {
            "id": 1,
            "user_id": 1,
            "honor": "2020哔哩哔哩商业技术优秀员工"
        },
        {
            "id": 2,
            "user_id": 1,
            "honor": "2021哔哩哔哩商业技术优秀员工"
        }
    ],
    "cert": [
        {
            "id": 1,
            "user_id": 1,
            "cert_name": "PMP项目管理专业人士资格认证"
        },
        {
            "id": 2,
            "user_id": 1,
            "cert_name": "大学英语六级"
        }
    ]
}
```
