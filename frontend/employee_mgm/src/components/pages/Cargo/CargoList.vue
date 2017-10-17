<template>
    <div class="cargolist">
        <div class="col-md-12 animated fadeIn">

            <div align="center">
                <h2>Cargos Cadastrados! </h2>
            </div>
            <br />

            <b-card>
                <div class="row">
                    <div class="col-md-4">
                        <b-card title="Cargos">
                            <b-list-group>
                                <b-list-group-item v-for="cargo in cargos" v-bind:key="cargo.id">
                                    <b> Cargo: </b>{{cargo.dscCargo}}
                                </b-list-group-item>
                            </b-list-group>
                        </b-card>
                    </div>

                    <div class="col-md-8">
                        <div class="row">

                        </div>
                    </div>
                </div>
            </b-card>

            <br />
            <router-link class="btn btn-success" to="/cargo/new">Novo Cargo</router-link>

        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'cargolist',
    data() {
        return {
            cargos: [],
            camposTabela: [
                {
                    key: 'Nome',
                    sortable: true
                },
                {
                    key: 'Valor',
                    sortable: false
                }
            ]

        }
    },

    created() {

    },

    mounted() {
        this.getCargos();
    },
    methods: {

        getCargos() {
            axios.get('http://localhost:8080/employee-management/cargo/all')
                .then(response => this.cargos = response.data)
                .catch(function(error) {
                    console.log(error);
                });
        }

    }

}
</script>

<style scoped>
.cardsize {
    max-width: 20rem;
    max-height: 40rem;
}

.customcard {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    transition: 0.3s;
    width: 20%;
    border-radius: 5px;
}

.customcard:hover {
    box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

img {
    border-radius: 5px 5px 0 0;
}
</style>
