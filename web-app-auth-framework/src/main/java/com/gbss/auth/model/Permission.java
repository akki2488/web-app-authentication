package com.gbss.auth.model;

import com.gbss.framework.core.model.entities.Base;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Akshay Misra on 15-11-2018.
 */
@Document(collection="permissions")
public class Permission extends Base {
}
