/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 * 
 * Copyright 2012 Benoit 'BoD' Lubek (BoD@JRAF.org).  All Rights Reserved.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jraf.androidcontentprovidergenerator.model;

import java.util.Date;

import org.apache.commons.lang.WordUtils;

public class Field {
    public static final String NAME = "name";
    public static final String TYPE = "type";

    public static enum Type {
        TEXT("TEXT", String.class), INTEGER("INTEGER", Long.class), FLOAT("FLOAT", Double.class), BLOB("BLOB", byte[].class), DATE("INTEGER", Date.class), ;

        private String mSqlType;
        private Class<?> mJavaType;

        private Type(String sqlType, Class<?> javaType) {
            mSqlType = sqlType;
            mJavaType = javaType;
        }

        public static Type fromString(String s) {
            return valueOf(s.toUpperCase());
        }

        public String getSqlType() {
            return mSqlType;
        }

        public Class<?> getJavaType() {
            return mJavaType;
        }
    }

    private final String mName;
    private final Type mType;

    public Field(String name, String type) {
        mName = name.toLowerCase();
        mType = Type.fromString(type);
    }

    public String getNameUpperCase() {
        return mName.toUpperCase();
    }

    public String getNameLowerCase() {
        return mName;
    }

    public String getNameCamelCase() {
        return /*StringUtils.uncapitalize(*/WordUtils.capitalizeFully(mName, new char[] { '_' }).replaceAll("_", "")/*)*/;
    }

    public Type getType() {
        return mType;
    }

    @Override
    public String toString() {
        return "Field [mName=" + mName + ", mType=" + mType + "]";
    }
}
