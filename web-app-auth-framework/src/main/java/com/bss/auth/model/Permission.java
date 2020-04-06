package com.bss.auth.model;

import com.bss.framework.core.schema.model.Base;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Akshay Misra on 15-11-2018.
 */
@Document(collection="permissions")
public class Permission extends Base {
}
