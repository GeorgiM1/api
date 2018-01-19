package com.example.android.api.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.api.R;
import com.example.android.api.model.BookModel;
import com.example.android.api.model.Books;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 1/18/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context context;
    BookModel bookModel;

    public ItemAdapter(Context context, BookModel bookModel) {
        this.context = context;
        this.bookModel = bookModel;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.items,parent, false);
        ViewHolder viewHolder = new ViewHolder (view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        Books books = bookModel.getBooks().get(position);

        Picasso.with(context).load(books.getVolumeInfo().getImageLinks().getThumbnail()).centerCrop().fit().into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return bookModel.getBooks().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
