
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import CookManager from "./components/listers/CookCards"
import CookDetail from "./components/listers/CookDetail"

import PayManager from "./components/listers/PayCards"
import PayDetail from "./components/listers/PayDetail"


import OrderDashboardView from "./components/OrderDashboardView"
import OrderDashboardViewDetail from "./components/OrderDashboardViewDetail"
import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/cooks',
                name: 'CookManager',
                component: CookManager
            },
            {
                path: '/cooks/:id',
                name: 'CookDetail',
                component: CookDetail
            },

            {
                path: '/pays',
                name: 'PayManager',
                component: PayManager
            },
            {
                path: '/pays/:id',
                name: 'PayDetail',
                component: PayDetail
            },


            {
                path: '/orderDashboards',
                name: 'OrderDashboardView',
                component: OrderDashboardView
            },
            {
                path: '/orderDashboards/:id',
                name: 'OrderDashboardViewDetail',
                component: OrderDashboardViewDetail
            },
            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },



    ]
})
