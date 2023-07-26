# auto-generate-api
自动生成代码工具

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
### 属性字段
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