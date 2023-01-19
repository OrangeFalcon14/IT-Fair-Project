<template>
    <div class="backdrop" @click.self="closeModal">
        <div class="modal">
            <label>Name: </label>
            <input type="text" name="nameInput" id="nameInput" v-model="name" @keydown="handlekeydown"/>
        </div>
    </div>
</template>

<script>
export default{
    data() {
        return{
            name: ''
        }
    },
    methods: {
        handlekeydown(event){
            if(event.key == "Enter")this.closeModal();
        },
        closeModal(){
            this.$emit("close", {from: "modal", name: this.name})
        }
    }
}
</script>

<style>
@keyframes fade{
    from{
        opacity: 0;
    }
    to{
        opacity: 1;
    }
}
@keyframes slide-top{
    from{
        top: -10em;
    }
    to{
        top: 50%;
        transform: translate(-50%, -50%);
    }
}

 .modal {
    position: absolute;
    left: 50%;
    transform: translate(-50%, 0);
    width: 400px;
    padding: 20px;
    margin: 100px auto;
    border-radius: 10px;
    background: #282828;
    animation: slide-top 0.5s;
  }
  .backdrop {
    top: 0;
    left: 0;
    position: fixed;
    background: rgba(0,0,0,0.5);
    width: 100%;
    height: 100%;
    animation: fade 0.5s;
  }
  input{
    background: #383838;
    border: none;
    padding: 10px;
    border-radius: 5px;
    margin-left: 5px;
    color: white;
  }
</style>
