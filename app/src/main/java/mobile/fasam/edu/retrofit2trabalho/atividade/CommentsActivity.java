package mobile.fasam.edu.retrofit2trabalho.atividade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import mobile.fasam.edu.retrofit2trabalho.R;
import mobile.fasam.edu.retrofit2trabalho.adapter.CommentsAdapter;
import mobile.fasam.edu.retrofit2trabalho.bootstrap.BootstrapApi;
import mobile.fasam.edu.retrofit2trabalho.representacao.Comments;
import mobile.fasam.edu.retrofit2trabalho.resource.CommentsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class CommentsActivity extends AppCompatActivity {


        EditText txtID;
        EditText txtUserId;
        EditText txtNome;
        EditText txtEmail;
        EditText txtBody;
        ListView listView;


        //Cria referencia para consumir o serviço do postservice
        CommentsService commentsService;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_comments);
        }

        private void carregarDados()
        {
            //fazer injeção de dependencia da interface
            commentsService = BootstrapApi.getClient().create(CommentsService.class);

            Call<List<Comments>> get = commentsService.get();

            get.enqueue(new Callback<List<Comments>>() {
                @Override
                public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                    //recuperar a lista de comments
                    List<Comments> posts = response.body();

                    //pegar os dados da listview
                    listView = findViewById(R.id.listViewComments);

                    //chamar o adpter para trabalhar os dados
                    CommentsAdapter adapter = new CommentsAdapter(getApplicationContext(), posts);

                    //fazer o "bind" com a listview
                    listView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<Comments>> call, Throwable t) {

                }
            });


}

        public void adicionar(View view) {

            carregarDados();
        }
        }
