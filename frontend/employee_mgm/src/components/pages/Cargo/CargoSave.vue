<template>
    <div class="newcargo">
        <div class="col-md-12 animated fadeIn">
            <div align="center">
                <div class="col-md-12" align="center">
                    <div class="jumbotron">
                        <h3 class="display-4">Novo Cargo</h3>
                        <p class="lead">Cadastro de novo cargo no sistema.</p>
                        <hr class="my-1">
                    </div>
                </div>
            </div>

            <div class="col-md-12">
                <form method="post">
                    <div class="row">
                        <fieldset class="col-md-12">
                            <legend>Novo Cargo</legend>

                            <div class="row">
                                <div class="form-group col-md-4">
                                    <label for="nomeCargo">Nome do Cargo</label>
                                    <input type="text" class="form-control" id="nomeCargo" v-model="cargo.dscCargo" placeholder="Digite O Nome do Cargo !">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-2">
                                    <label for="setorcargo">Setor</label>
                                    <select class="form-control" id="setorcargo" v-model="cargo.cargoSetor">
                                        <option>Selecione </option>
                                        <option v-for="setor in setores" v-bind:key="setor.setorId" v-bind:value="setor">{{setor.dscSetor}}</option>
                                    </select>
                                </div>
                            </div>

                        </fieldset>
                    </div>
                    <br />
                    <div class="row">

                        <fieldset class="col-md-6">
                            <legend>Incidencias Salarias</legend>
                            <b-form-checkbox-group name="incidenciasSalariais" v-model="cargo.cargoIncidenciasSalario">
                                <b-form-checkbox v-for="incidenciaSalario in incidenciasSalariais" v-bind:value="incidenciaSalario" v-bind:key="incidenciaSalario.idIncidenciaSalario">
                                    <b>Nome: </b> {{incidenciaSalario.nomeIncidenciaSalario}}<br/>
                                </b-form-checkbox>
                            </b-form-checkbox-group>
                        </fieldset>

                        <fieldset class="col-md-6" v-if="cargo.cargoIncidenciasSalario.length > 0">
                            <legend>Detalhes Incidencias Salariais</legend>
                            <div>
                                <b-card-group deck class="mb-3">
                                    <b-card text-variant="black" bg-variant="light" header-bg-variant="success" header="Informação Incidencia Salarial" class="text-center animated fadeInDown" v-for="incidenciaSalario in cargo.cargoIncidenciasSalario" v-bind:key="incidenciaSalario.idIncidenciaSalario">
                                        <p class="card-text">
                                            <b>Nome: </b>{{incidenciaSalario.nomeIncidenciaSalario}}<br/>
                                            <b>Valor: R$ </b>{{incidenciaSalario.valorIncidenciaSalario}}<br/>
                                            <b>Tipo de Incidencia: </b>{{incidenciaSalario.tipoIncidenciaSalario}}<br/>
                                        </p> <br/>
                                    </b-card>
                                </b-card-group>

                            </div>

                        </fieldset>
                    </div>

                    <br />
                    <div align="center">
                        <button v-on:click="saveCargo" type="button" class="btn btn-primary">Salvar</button>
                        <router-link class="btn btn-success" to="/cargo/all">Voltar</router-link>
                    </div>
                </form>
            </div>

        </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'newcargo',

    data() {
        return {
            setores: [],
            incidenciasSelecionadas: [],
            incidenciasSalariais: [],
            cargo: {
                dscCargo: '',
                cargoSetor: '',
                cargoIncidenciasSalario: [],
            }
        }
    },
    created() {
        this.getIncidenciasSalario();
        this.getSetoresCargo();
    },

    mounted() {

    },

    methods: {

        getIncidenciasSalario() {
            axios.get('http://localhost:8080/employee-management/incidencia-salario/all')
                .then(response => { this.incidenciasSalariais = response.data; console.log(response) })
                .catch(function(error) {
                    console.log(error);
                });
        },

        getSetoresCargo() {
            fetch('http://localhost:8080/employee-management/setor/all')
                .then(response => {
                    response.json().then(data => this.setores = data);
                    console.log(this.setores)
                }).catch(error => {
                    console.log(error);
                })

        },

        saveCargo() {
            axios.post('http://localhost:8080/employee-management/cargo',
                {
                    dscCargo: this.cargo.dscCargo,
                    cargoIncidenciasSalario: this.cargo.cargoIncidenciasSalario,
                    cargoSetor: this.cargo.cargoSetor
                })
                .then(response => {
                    console.log('salvo com sucesso ', response)
                    this.$router.push({ path: '/cargo/all' })
                })
                .catch(function(error) {
                    console.log(error);
                });
        }


    }

}
</script>

<style scoped>

</style>
