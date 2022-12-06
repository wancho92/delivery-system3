<template>

    <v-data-table
        :headers="headers"
        :items="orderDashboard"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderDashboardView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "status", value: "status" },
            ],
            orderDashboard : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderDashboards'))

            temp.data._embedded.orderDashboards.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderDashboard = temp.data._embedded.orderDashboards;
        },
        methods: {
        }
    }
</script>

