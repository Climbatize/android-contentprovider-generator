<#if header??>
${header}
</#if>
package ${config.providerPackage};

import java.util.Date;

import android.database.Cursor;

/**
 * Cursor wrapper for the {@code ${entity.nameLowerCase}} table.
 */
public class ${entity.nameCamelCase}CursorWrapper extends AbstractCursorWrapper {
    public ${entity.nameCamelCase}CursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Long getId() {
        return getLongOrNull(${entity.nameCamelCase}Columns._ID);
    }
    <#list entity.fields as field>

    public ${field.type.javaType.simpleName} get${field.nameCamelCase}() {
        <#switch field.type.name()>
        <#case "TEXT">
        Integer index = getCachedColumnIndexOrThrow(${entity.nameCamelCase}Columns.${field.nameUpperCase});
        return getString(index);
        <#break>
        <#case "BLOB">
        Integer index = getCachedColumnIndexOrThrow(${entity.nameCamelCase}Columns.${field.nameUpperCase});
        return getBlob(index);
        <#break>
        <#case "INTEGER">
        return getLongOrNull(${entity.nameCamelCase}Columns.${field.nameUpperCase});
        <#break>
        <#case "FLOAT">
        return getDoubleOrNull(${entity.nameCamelCase}Columns.${field.nameUpperCase});
        <#break>
        <#case "DATE">
        return getDateOrNull(${entity.nameCamelCase}Columns.${field.nameUpperCase});
        <#break>
        </#switch>
    }
    </#list>
}
