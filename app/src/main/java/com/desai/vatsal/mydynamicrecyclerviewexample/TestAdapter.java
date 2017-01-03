package com.desai.vatsal.mydynamicrecyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HCL on 14-11-2016.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MenuViewHolder> {

    private Context context;
    private ArrayList<ProgramModel> program;

    public TestAdapter(Context context, ArrayList<ProgramModel> program) {
        this.context = context;
        this.program = program;
    }

    public void setTestList(ArrayList<ProgramModel> program) {
        this.program = new ArrayList<>();
        this.program = program;
        notifyDataSetChanged();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_image;
        TextView tv_title, tv_msg;
        RelativeLayout parent_layout;

        public MenuViewHolder(View itemView) {
            super(itemView);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_msg = (TextView) itemView.findViewById(R.id.tv_msg);
            parent_layout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);

        }

        public void setMenuDetail(ProgramModel model, final int position) {

            tv_title.setText(model.getTitle());
            tv_msg.setText(model.getTitle());
            iv_image.setImageResource(model.getImage());

        }

    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_program_list, parent, false);
        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        ProgramModel menuModel = program.get(position);
        holder.setMenuDetail(menuModel, position);
    }

    @Override
    public int getItemCount() {
        return program.size();
    }

}
