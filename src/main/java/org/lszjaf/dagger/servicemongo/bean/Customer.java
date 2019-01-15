package org.lszjaf.dagger.servicemongo.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @CompoundIndex
 * 复合索引，加复合索引后通过复合索引字段查询将大大提高速度
 * @Field
 * 代表一个字段，可以不加，不加的话默认以参数名为列名。
 * @Transient
 * 被该注解标注的，将不会被录入到数据库中。只作为普通的javaBean属性。
 * @DBRef
 * 关联另一个document对象。类似于mysql的表关联，但并不一样，mongo不会做级联的操作。
 *
 */
@Document(collection = "customer")//在mongo中的集合名词,标注在实体类上，类似于hibernate的entity注解，标明由mongo来维护该表。
public class Customer {

    @Id//主键，不可重复，自带索引，
    public String id;

    /**
     * 声明该字段需要加索引，加索引后以该字段为条件检索将大大提高速度。
     * 唯一索引的话是@Indexed(unique = true)。
     * 也可以对数组进行索引，如果被索引的列是数组时，MongoDB会索引这个数组中的每一个元素。
     * 也可以对整个Document进行索引，排序是预定义的按插入BSON数据的先后升序排列。
     * 也可以对关联的对象的字段进行索引，譬如User对关联的address.city进行索引。
     */
    @Indexed
    public String firstName;
    public String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
