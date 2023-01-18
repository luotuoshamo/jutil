package cn.topicstudy.area.division;

enum DivisionTypeEnum {
   PROVINCE("省"), CITY("市"), DISTRICT("区");

   private String desc;

   public String getDesc() {
      return desc;
   }

   public void setDesc(String desc) {
      this.desc = desc;
   }

   DivisionTypeEnum(String desc) {
      this.desc = desc;
   }
}
