package com.luoli.mydrawing.utils;

/**
 * 接口
 * Created by Administrator on 2016/9/22.
 */
public interface Urls {
    /**
     * 接入H5
     ********************************************************************************/
    String UrlBaseH5 = "http://anhubo.com/";
    //String UrlBaseH5 = "http://test.anhubo.com/";
    /**
     * Android原生
     ********************************************************************************/
    String UrlBase = "http://anhubo.com/api/";
    //String UrlBase = "http://test.anhubo.com/api/";
    /**
     * 发现，反馈
     */
    String Url_FindFeed = UrlBaseH5 + "s/html/feedBackSchedule.html";
    /**
     * 发现，公告
     */
    String Url_FindNotice = UrlBaseH5 + "/s/html/afficheList.html";
    /**
     * 学习
     */
//    String Url_UnitStudy = UrlBaseH5 + "s/html/answerSheetAO.html";
    String Url_UnitStudy = UrlBaseH5 + "anhubo_web/answerSheet.html#/studyModule";
    /**
     * 邀请注册
     */
    String Url_MyInvare = UrlBaseH5 + "s/html/inviteRegisterAO.html";
    /**
     * 邀请 微信
     */
    String Url_MyInvare_WeiXin = UrlBaseH5 + "s/html/InviteShare.html";

    /**
     * 关于我们
     */
    String Url_MyAboutWe = UrlBaseH5 + "s/html/AboutAnhubo.html";
    /**
     * 安互保协议
     */
    String Url_Deal = UrlBaseH5 + "s/html/registerTreaty.html";
    /**
     * 反馈成功
     */
    String Url_FeedBackSuccess = UrlBaseH5 + "s/html/feedBackOK.html";
    /**
     * 使用指导
     */
    String Url_UseGuide = UrlBaseH5 + "s/html/userDirection/userList.html";
    /**
     * 我的 订单管理
     */
    String Url_MyOrderManager = UrlBaseH5 + "s/html/orderFormList.html";
    /**
     * 互保计划
     */
    String Url_HuBaoPlan = UrlBaseH5 + "anhubo_s/anhubo_concur/html/concurProgram.html";
    /**
     * 加入单元&&创建单元
     */
    String Url_Unit_Cell = UrlBaseH5 + "anhubo_s/anhubo_concur/html/addCellOk.html";
    /**
     * 单元 分享
     */
    String Url_Cell_WeiXin = UrlBaseH5 + "anhubo_s/anhubo_concur/html/concurProgram.html";


/***************************登录注册********* **********************/
    /**
     * 获取验证的token
     */
    String Url_Token = "http://anhubo.com/api/Sms/get_verify_token";
    /**
     * 获取验证码
     */
    String Url_Security = "http://anhubo.com/api/Sms/Send_VerifyCode";
    /**
     * 注册第一个页面的下一步按钮的接口
     */
    String Url_Enter_RegisterActivity2 = UrlBase + "User/register";
    /**
     * 短信登录
     */
    String Url_LoginMsg = UrlBase + "User/duanxinLogin";
    /**
     * 密码注册
     */
    String Url_PwdRegister = UrlBase + "User/registerSecond";
    /**
     * 密码登录
     */
    String Url_LoginPwd = UrlBase + "User/mimaLogin";
    /**
     * 登录  忘记密码
     */
    String Url_Login_AlterPwd = UrlBase + "Personal/reget_pa";
    /**
     * 注册完成，信息填写完整
     */
    String Url_RegCom = UrlBase + "User/businessRegister";
    /**
     * 正常登录绑定微信
     */
    String Url_BindWEIXIN = UrlBase + "Personal/bind_third";

    /***************************单位*******************************/


    /**
     * 新增界面
     */
    String Url_Add = UrlBase + "Device/add_device_info";
    /**
     * 新增设备，检查设备是否已经添加
     */
    String Url_Add_Check = UrlBase + "Device/dev_check_name";
    /**
     * 扫描界面的接口
     */
    String Url_Check = UrlBase + "Device/get_device_detail";
    /**
     * 设备名称选择
     */
    String Url_GetDevName = UrlBase + "Device/de_list";
    /**
     * 完成设备检查
     */
    String Url_Check_Complete = UrlBase + "Device/check_device_re";
    /**
     * 获取进度条信息
     */
    String Url_Get_Num = UrlBase + "Device/get_num";

    /**
     * 学习、检查记录
     */
    String Url_studyRecord = UrlBase + "Record/get_re_list";
    String Url_Unit = UrlBase + "BusinessChart/index";
    /**
     * 完善信息
     */
    String Url_MsgPerfect = UrlBase + "Quali/check_qu";
    /**
     * 完善信息员工数
     */
    String Url_MsgPerfect_Member = UrlBase + "Quali/get_user_num";
    /**
     * 场所使用性质
     */
    String Url_GetUsePro = UrlBase + "Pro/pro_list";
    /**
     * 上传营业执照
     */
    String Url_UpLoading01 = UrlBase + "Quali/thr_pic";
    /**
     * 法人身份证
     */
    String Url_UpLoading02 = UrlBase + "Quali/low_pic";
    /**
     * 上传消防审批
     */
    String Url_UpLoading03 = UrlBase + "Quali/notice";
    /**
     * 上传租房
     */
    String Url_UpLoading04 = UrlBase + "Quali/rent_pic";
    /**
     * 上传场所使用性质
     */
    String Url_UpLoading06 = UrlBase + "Pro/add_bu_pro";
    /**
     * 消息中心
     */
    String Url_UnitMsgCenter = UrlBase + "Push/msg_list";
    /**
     * 单位下所有设备列表
     */
    String Device_List = UrlBase + "Device/check_device_list";

    /**
     * 待处理反馈界面处理页
     */
    String Url_Check_Pending_FeedBack = UrlBase + "Issue/issue_detail";
    /**
     * 待处理反馈界面提交
     */
    String Url_PendFeedBack = UrlBase + "Issue/deal_issue";
    /**
     * 问题反馈
     */
    String Url_FeedBack = UrlBase + "Issue/add_issue";
    /**
     * 定位
     */
    String Location = UrlBase + "Building/get_addrest";
    /**
     * 获取测试项
     */
    String Url_Build_Test = UrlBase + "Device/require_list_an";
    /**
     * 提交测试项
     */
    String Url_Test_Submit = UrlBase + "Device/sub_res";
    /**
     * 邀请同事
     */
    String Url_Unit_InvateWorkMate = UrlBase + "Work/in_wo_mate";
    /**
     * 上传Registration_Id
     */
    String Url_Registration_Id = UrlBase + "Device/add_token";
    /**
     * 推送  同事修改单位
     */
    String Url_Unit_AlterUnit = UrlBase + "Work/save_bu_info";
    /**
     * 删除设备
     */
    String Delete_Device = UrlBase + "Device/del_dev";
    /**
     * 单位下的动态凭证
     */
    String URL_UNIT_RUN_CERTIFICATE = UrlBase + "Plan/plan_certs";
    /**
     * 动态凭证详情
     */
    String URL_RUN_CERTIFICATE = UrlBase + "Plan/change_ensure";
    /**
     * 单元列表
     */
    String Url_Unit_List = UrlBase + "Unit/unit_list";
    /**
     * 单元详情
     */
    String Url_Unit_Detail = UrlBase + "Unit/unit_business";

    /**
     * 遮罩  单位注册
     */
    String Url_Unit_Register = UrlBase + "Business/business_register";
    /**
     * 建筑
     */
    String Url_Building_Register = UrlBase + "Building/add_business_by_map";
    /**
     * 单位 员工列表
     */
    String Url_EmployList = UrlBase + "Business/business_users_list";
    /**
     * 管理员转让
     */
    String Url_Assi_Admin = UrlBase + "Business/change_role";
    /**
     * 退出企业
     */
    String Url_Quit_Business = UrlBase + "Business/quit_business";
    /**区域绑定*/
    String Url_AreaBinding = UrlBase + "Escape/get_escape_pic";
    /**区域绑定 获取点的个数*/
    String Url_GetCurrentDot = UrlBase + "Escape/get_some_pic";
    /**获取疏散点*/
    String Url_Evacuate_Dot = UrlBase + "Escape/get_one_qr";
    /**获取疏散界面的的tenpId*/
    String Url_Evacuate_GetTempId = UrlBase + "Escape/create_temp_record";
    /**疏散拿到二维码信息获取对应点坐标信息*/
    String Url_Evacuate_Card = UrlBase + "Escape/get_qr_name";
    /**完成区域绑定*/
    String Url_Complete_Bind = UrlBase + "Escape/bind_qrcode";
    /**疏散退出*/
    String Url_EvacuateQuit= UrlBase + "Escape/finish_es";






/***************************建筑*******************************/
    /**
     * 建筑下建筑安全指数，三色环比
     */
    String Url_Build_score = UrlBase + "BuildingChart/details";
    /**
     * 建筑，三色预警
     */
    String Url_Build_ThreeColour = UrlBase + "BuildingChart/Threec";
    /**
     * 建筑,互助计划
     */
    String Url_Build_Help_Plan = UrlBase + "Plan/plan_list";


/***************************计划********************************/

    /**计划模块*/
    String Url_PlanModule = UrlBase + "Plan/shunt_users";
    /**计划管理*/
    String Url_PlanManage = UrlBase + "Plan/manager_warming";
    /**加入其他计划*/
    String Url_JoinPlan = UrlBase + "Plan/other_plans";
    /**成员情况 会员详情*/
    String Url_PlanMember = UrlBase + "Plan/user_detail";
    /**单元列表*/
    String Url_PlanUnitList = UrlBase + "Plan/more_units";
    /**对账单列表*/
    String Url_PlanHelpSumMoney = UrlBase + "Plan/bill_pic";
    /**上传对账单*/
    String Url_UpLoadingHelpSumMoney = UrlBase + "Plan/upload_pic";
/***************************我的*******************************/
    /**
     * 我的，上传头像
     */
    String Url_UpLoadingHeaderIcon = UrlBase + "Personal/save_pic";
    /**
     * 我的，获取用户信息
     */
    String Url_My_GetUserInfo = UrlBase + "Personal/get_us_info";
    /**
     * 我的，修改姓名
     */
    String Url_My_Name = UrlBase + "Personal/change_name";
    /**
     * 我的，修改性别
     */
    String Url_My_Gender = UrlBase + "Personal/change_sex";
    /**
     * 我的，修改年龄
     */
    String Url_My_Age = UrlBase + "Personal/birthday";
    /**
     * 我的，修改密码
     */
    String Url_My_AlterPwd = UrlBase + "Personal/change_pwd";
    /**
     * 我的，身份证认证
     */
    String Url_IdCard = UrlBase + "Personal/save_true";
    /**
     * 我的，证件认证
     */
    String Url_Engineer = UrlBase + "Personal/indent";
    /**
     * 我的，微信登录
     */
    String Url_LoginWEIXIN = UrlBase + "Personal/third_part_login";
    /**
     * 我的  修改单位
     */
    String Url_AlterUnit = UrlBase + "Personal/change_business";

    /**
     * 微信分享
     */
    String Url_MyShare = UrlBase + "Personal/share";

    /**
     * 检查更新
     */
    String Url_Check_Update = UrlBase + "Index/version_change";
}
