<template>
    <div>
        <input type="checkbox" id="product-item" :checked="isDone" />
        <label for="product-item">{{label}}</label>
    </div>
</template>

<script>
    //import uniqueId from 'lodash.uniqueid';

    export default {
        props: {
            label: { required: true, type: String },
            done: { default: false, type: Boolean }
        },
        data() {
            return {
                isDone: this.done,
                //id: uniqueId('product-')
            };
        }
    };
</script>

