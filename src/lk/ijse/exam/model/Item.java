/*---------------------------------------------------------------------------------------------
 *  Copyright (c) IJSE. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package lk.ijse.exam.model;

/**
 * @author Pamod Bulathgama <cbulathgama8@gmail.com>
 * @since 8/7/21
 */
public class Item {
    private String id;
    private String name;
    private int qty;

    public Item() {
    }

    public Item(String id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }
}
