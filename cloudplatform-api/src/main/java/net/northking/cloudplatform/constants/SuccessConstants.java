package net.northking.cloudplatform.constants;

/**
 * @Title:
 * @Description: 成功码常量
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2018-01-09 10:03
 * @UpdateUser:
 * @Version:0.1
 */


public class SuccessConstants {

    /**
     * @Author:HBH
     * @Description: 用户微服务部分
     * @Date:10:06 2018/1/9
     * @param1:
     * @param2:
     * @return:
     */
    //用户部分
    public static final String ADD_USER_INFO_SUCCESS="添加用户信息成功!";

    public static final String QUERY_USER_LIST_INFO_SUCCESS="查询用户列表信息成功!";

    public static final String QUERY_ENABLE_USER_LIST_INFO_SUCCESS="查询用户列表信息成功!";

    public static final String QUERY_USER_INFO_BY_USER_ID_SUCCESS="查询用户详细信息成功!";

    public static final String UPDATE_USER_INFO_BY_USER_ID_SUCCESS="编辑用户详细信息成功!";

    public static final String UPDATE_USER_STATUS_BY_USER_ID_AND_STATUS_SUCCESS="操作成功!";

    public static final String QUERY_USER_LIST_BY_ORG_ID_SUCCESS="查询用户列表成功!";

    public static final String DELETE_USER_BATCH_BY_USER_IDS_SUCCESS="删除用户成功!";

    public static final String UPDATE_ORG_BY_USER_IDS_SUCCESS="修改机构成功!";

    public static final String QUERY_USER_LIST_BY_ROLE_CODE_SUCCESS="查询用户列表成功!";

    public static final String QUERY_USER_LIST_BY_USER_TYPE_SUCCESS="查询用户列表成功!";

    public static final String CHECK_USER_LOGING_NUM_SUCCESS="该登录名可以使用!";

    //角色部分

    public static final String ADD_CLT_ROLE_INFO_SUCCESS="添加角色信息成功!";

    public static final String UPDATE_CLT_ROLE_INFO_SUCCESS="编辑角色信息成功!";

    public static final String QUERY_ROLE_LIST_BY_PRO_ID_SUCCESS="查询角色列表成功!";

    public static final String QUERY_ROLE_LIST_SUCCESS="查询角色列表成功!";

    public static final String QUERY_ROLE_LIST_IS_NOT_SUPER_SUCCESS="查询角色列表成功!";

    public static final String QUERY_CLT_ROLE_INFO_BY_ROLE_ID_SUCCESS="查询角色详细信息成功!";

    public static final String DELETE_ROLE_BATCH_BY_ROLE_IDS_SUCCESS="批量删除角色信息成功!";

    public static final String QUERY_ROLE_LIST_BY_ROLE_CODE_SUCCESS="查询角色列表成功!";


    //用户角色部分

    public static final String ADD_CLT_USER_ROLE_SUCCESS="添加用户角色关系成功!";

    public static final String QUERY_ROLE_LIST_BY_USER_ID_SUCCESS="查询用户下的角色列表成功!";

    public static final String DELETE_CLT_USER_ROLE_BATCH_BY_USER_ROLE_IDS_SUCCESS="批量解除用户角色关系成功!";

    public static final String ADD_CLT_USER_ROLE_BATCH_SUCCESS="批量添加用户角色关系成功!";

    public static final String UPDATE_CLT_USER_ROLE_SUCCESS="修改用户角色关系成功!";

    public static final String DELETE_CLT_USER_ROLE_BY_USER_AND_ROLE_ID_SUCCESS="解除用户角色关系成功!";

    //机构部分

    public static final String ADD_CLT_ORG_INFO_SUCCESS="添加机构信息成功!";

    public static final String UPDATE_CLT_ORG_INFO_SUCCESS="修改机构信息成功!";

    public static final String DELETE_CLT_ORG_INFO_BY_ORG_ID_SUCCESS="删除机构信息成功!";

    public static final String QUERY_CLT_ORG_INFO_BY_ORG_ID_SUCCESS="查询机构详细信息成功!";

    public static final String QUERY_ORG_LIST_SUCCESS="查询机构列表成功!";

    public static final String UPDATE_CLT_ORG_BY_PARENT_ID_AND_CUST_ID_SUCCESS="更新机构成功!";

    public static final String DELETE_CLT_ORG_BY_PARENT_ID_AND_CUST_ID_SUCCESS="删除机构成功!";

   //功能部分

    public static final String QUERY_FUNC_LIST_SUCCESS="查询功能列表成功!";

    //功能角色部分

    public static final String DELETE_CLT_ROLE_FUNC_BATCH_BY_ROLE_FUNC_IDS_SUCCESS="批量解除功能角色关系成功!";

    public static final String QUERY_FUNC_LIST_BY_ROLE_ID_SUCCESS="查询功能列表成功!";

    public static final String ADD_CLT_ROLE_FUNC_BATCH_BY_ROLE_FUNC_IDS_SUCCESS="批量添加功能角色关系成功!";

    /**
     * @Author:HBH
     * @Description: 项目微服务
     * @Date:15:26 2018/1/9
     * @param1:
     * @param2:
     * @return:
     */

    //项目部分

    public static final String ADD_CLT_PROJECT_INFO_SUCCESS="添加项目信息成功!";

    public static final String QUERY_PROJECT_LIST_SUCCESS="查询项目列表成功!";

    public static final String QUERY_CLT_PROJECT_INFO_BY_PRO_ID_SUCCESS="查询项目详情成功!";

    public static final String UPDATE_CLT_PROJECT_INFO_SUCCESS="编辑项目信息成功!";

    public static final String UPDATE_PROJECT_STATUS_SUCCESS="操作成功!";

    public static final String QUERY_PROJECT_LIST_BY_USER_ID_SUCCESS="查询项目列表成功!";

    public static final String QUERY_USER_ROLE_BY_PRO_ID_SUCCESS="查询项目下的用户和角色成功!";

    public static final String QUERY_PROJECT_LIST_BY_CUST_ID_SUCCESS="查询客户下的项目成功!";

    public static final String QUERY_FUNC_LIST_BY_PRO_AND_USER_ID_SUCCESS="查询项目下功能列表成功!";

    //测试团队部分
    public static final String ADD_CLT_PROJECT_TEAM_INFO_SUCCESS="创建团队成功!";

    public static final String DELETE_CLT_PROJECT_TEAM_INFO_SUCCESS="移除团队成功!";

    public static final String QUERY_CLT_PROJECT_TEAM_INFO_BY_USER_AND_ROLE_PRO_ID_SUCCESS="查询团队信息成功!";

    public static final String COUNT_CLT_PROJECT_TEAM_INFO_BY_USER_AND_ROLE_PRO_ID_SUCCESS="查询团队信息成功!";

    /**
     * @Author:HBH
     * @Description: 客户微服务部分
     * @Date:19:36 2018/1/9
     * @param1:
     * @param2:
     * @return:
     */

    public static final String ADD_CLT_CUSTOMER_INFO_SUCCESS="添加客户信息成功!";

    public static final String UPDATE_CLT_CUSTOMER_INFO_SUCCESS="编辑客户信息成功!";

    public static final String QUERY_CUSTOMER_LIST_SUCCESS="查询客户列表成功!";

    public static final String QUERY_CLT_CUSTOMER_INFO_BY_CUST_ID_SUCCESS="查询客户详细信息成功!";

    public static final String QUERY_CLT_CUSTOMER_INFO_BY_CUST_CODE_SUCCESS="查询客户详细信息成功!";

    public static final String COUNT_CLT_CUSTOMER_INFO_BY_CUST_CODE_SUCCESS="查询客户详细信息成功!";

    public static final String DELETE_CLT_CUSTOMER_INFO_BY_CUST_ID_SUCCESS="删除客户信息成功!";

    public static final String UPDATE_CLT_CUSTOMER_STATUS_SUCCESS="操作成功!";


    /**
     * @Author:HBH
     * @Description: 字典微服务部分
     * @Date:19:47 2018/1/9
     * @param1:
     * @param2:
     * @return:
     */

    public static final String ADD_CLT_DICTIONARY_TYPE_INFO_SUCCESS="添加数据字典类型信息成功!";

    public static final String ADD_CLT_DICTIONARY_ITEM_INFO_SUCCESS="添加数据字典类目信息成功!";

    public static final String DELETE_CLT_DICTIONARY_TYPE_INFO_SUCCESS="删除数据字典类型信息成功!";

    public static final String DELETE_CLT_DICTIONARY_ITEM_INFO_SUCCESS="删除数据字典类目信息成功!";

    public static final String UPDATE_CLT_DICTIONARY_TYPE_INFO_SUCCESS="更新数据字典类型信息成功!";

    public static final String DPDATE_CLT_DICTIONARY_ITEM_INFO_SUCCESS="更新数据字典类目信息成功!";

    public static final String QUERY_DICTIONARY_ITEM_LIST_BY_TYPE_ID_SUCCESS="查询数据字典类目列表成功!";

    public static final String QUERY_DICTIONARY_TYPE_LIST_SUCCESS="查询数据字典类型列表成功!";

    public static final String DELETE_DICTIONARY_TYPE_BATCH_SUCCESS="批量删除数据字典类型列表成功!";

    public static final String DELETE_DICTIONARY_ITEM_BATCH_SUCCESS="批量删除数据字典类目列表成功!";

    public static final String UPDATE_DICTIONARY_STATUS_SUCCESS="操作成功!";

    public static final String UPDATE_DICTIONARY_ORDER_SEQ_SUCCESS="操作成功!";


/**
 * @Author:HBH
 * @Description: 缺陷微服务部分
 * @Date:9:46 2018/1/10
 * @param1:
 * @param2:
 * @return:
 */

  //缺陷管理部分
    public static final String ADD_CLT_TEST_BUG_INFO_SUCCESS="添加缺陷成功!";

    public static final String QUERY_TEST_BUG_LIST_SUCCESS="查询缺陷列表成功!";

    public static final String QUERY_TEST_BUG_INFO_SUCCESS="查询缺陷详情成功!";





}
