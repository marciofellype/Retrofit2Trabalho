package mobile.fasam.edu.retrofit2trabalho.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import mobile.fasam.edu.retrofit2trabalho.R;
import mobile.fasam.edu.retrofit2trabalho.representacao.Comments;

public class CommentsAdapter extends BaseAdapter {

        Context context;
        List<Comments> colecao;
        LayoutInflater inflter;

        public CommentsAdapter(final Context applicationContext,
                               final List<Comments> colecao) {
            this.context = applicationContext;
            this.colecao = colecao;
        }

        @Override
        public int getCount() {
            return this.colecao!=null ? this.colecao.size() :0;
        }

        @Override
        public Object getItem(int position) {
            return this.colecao.get(position);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            // inflate the layout for each list row
            //'Infla' o layout(pega a referencia) para ser trabalhada
            //no método
            if (view == null) {
                view = LayoutInflater.from(context).
                        inflate(R.layout.item_comments,
                                viewGroup, false);
            }

            // pega o objeto corrente da lista
            Comments comments = (Comments)getItem(position);

            //Neste ponto vc ira popular os dados do seu layout,
            //utilizando JAVA.

            //Declarar campos para prencher
            TextView userId, id, nome;

            //Pegando referencia do campo no layout
            userId = view.findViewById(R.id.txtUserId);
            nome = view.findViewById(R.id.txtNome);

            //prencher iten no layout como objeto comments
            userId.setText(String.valueOf(comments.getUserId()));
            nome.setText(String.valueOf(comments.getNome()));


            return view;
        }
}
