package mobile.fasam.edu.retrofit2trabalho.resource;

import java.util.List;

import mobile.fasam.edu.retrofit2trabalho.representacao.Comments;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


    public interface CommentsService {

        //Envia um post para o servidor
        @POST("")
        Call<Comments> post(@Body Comments comments);

        //Recupera u post aseado em id
        @GET("posts/{id}")
        Call<Comments> get(@Path("id") Integer id);

        //Tras a lista de posts
        @GET("posts")
        Call<List<Comments>> get();

        //Atualia o objeto comments inteiramente
        @PUT("comments/{id}")
        Call<Comments> put(@Path("id") Integer id, @Body Comments comments);

        //Atualia parcialmente um post
        @PATCH ("comments/{id}")
        Call<Comments> patch(@Path("id") Integer id, @Body Comments comments);

        //Apaga um post baseado em um ID
        @DELETE ("posts")
        Call<Void> delete(@Path("id") Integer id);
}
