# auto-generate-api
自动生成代码工具

## 功能规划

- [x] 根据数据库表结构生成java代码
- [x] 根据模板动态生成
- [x] 自定义字段映射类型
- [x] 自动生成项目结构
- [x] 生成的类名去除前缀
- [ ] 动态分组
- [ ] 多组模板自由切换
- [ ] 自定义新增模板

## 模板字段说明

### 表字段
```kotlin
    /**
     * 数据库表名
     */
    val tableName: String
    /**
     * 表描述内容，表注释
     */
    val tableComment: String
    /**
     * 大驼峰表名
     */
    val bigHumpTableName: String
    /**
     * 小驼峰表名
     */
    val smallHumpTableName: String
    /**
     * 小驼峰类名
     */
    val smallClassName: String
    /**
     * 类名
     */
    val className: String
    /**
     * 属性列表
     */
    val fieldInfos: List<FieldInfo>
    /**
     * 包名
     */
    var basePackage: String
```
### 属性字段(FieldInfo)
```kotlin
    val tableCatalog: Any?
    /**
     * 数据库名称
     */
    val tableSchema: String
    /**
     * 列名、字段名
     */
    val columnName: String
    /**
     * 属性名
     */
    val field: String
    /**
     * 序号位置
     */
    val ordinalPosition: Any?
    /**
     * 列默认值
     */
    val columnDefault: Any?
    /**
     * 是否可为null
     */
    val isNullable: Any?
    /**
     * 是否必填
     */
    val required: Boolean
    /**
     * 数据类型
     */
    val dataType: String
    /**
     * 字段注释
     */
    val columnComment: String?
    /**
     * 属性类型
     */
    val fieldType: String
```