package cn.topicstudy.jutil.basic.error;

//  errorCode枚举基类，项目中定义errorCode枚举时实现该接口
//  项目中加上：
//    SYS_ERROR("TS-{YourProjectName}-0-0", "系统错误"),
//
//    ;
//      private String errorCode;
//      private String errorMsg;
//
//      {YourProjectName}ErrorCodeEnum(String errorCode, String errorMsg) {
//          this.errorCode = errorCode;
//          this.errorMsg = errorMsg;
//      }
//
//      @Override
//      public String getErrorCode() {
//          return errorCode;
//      }
//
//      @Override
//      public String getErrorMsg() {
//          return errorMsg;
//      }

public interface BaseErrorCodeEnum {
    String getErrorCode();

    String getErrorMsg();
}
