// 代码生成时间: 2025-10-10 03:59:35
package com.example.b2b;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

// B2B采购系统 - 管理Bean
@ManagedBean
@ViewScoped
public class B2BPurchasingSystem {

    // 采购订单列表
    private List<PurchaseOrder> purchaseOrders;

    // 构造函数
    public B2BPurchasingSystem() {
        this.purchaseOrders = new ArrayList<>();
        // 模拟一些采购订单数据
        initPurchaseOrders();
    }

    // 初始化采购订单数据
    private void initPurchaseOrders() {
        PurchaseOrder order1 = new PurchaseOrder("001", "Product A", 100);
        PurchaseOrder order2 = new PurchaseOrder("002", "Product B", 200);
        purchaseOrders.add(order1);
        purchaseOrders.add(order2);
    }

    // 添加采购订单
    public void addPurchaseOrder() {
        PurchaseOrder newOrder = new PurchaseOrder(
            "", // 自动生成订单ID
            "New Product", // 新产品的名称
            0 // 初始数量
        );
        try {
            // 这里可以添加逻辑来保存订单到数据库
            purchaseOrders.add(newOrder);
            // 清空表单
            clearForm();
        } catch (Exception e) {
            // 错误处理
            System.out.println("Error adding purchase order: " + e.getMessage());
        }
    }

    // 清空表单
    public void clearForm() {
        // 这里可以添加逻辑来重置表单字段
    }

    // 获取采购订单列表
    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    // 设置采购订单列表
    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    // 采购订单类
    public static class PurchaseOrder {
        private String id;
        private String productName;
        private int quantity;

        public PurchaseOrder(String id, String productName, int quantity) {
            this.id = id;
            this.productName = productName;
            this.quantity = quantity;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
