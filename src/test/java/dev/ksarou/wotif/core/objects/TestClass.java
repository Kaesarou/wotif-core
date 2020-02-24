/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.objects;

public class TestClass {

    private final String property_1;

    private final Integer property_2;

    private final Boolean property_3;

    public TestClass(String property_1, Integer property_2, Boolean property_3) {
        this.property_1 = property_1;
        this.property_2 = property_2;
        this.property_3 = property_3;
    }

    public String getProperty_1() {
        return property_1;
    }
}
