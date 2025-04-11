package due.giuaky221121514202.ui.Day2_Listview.ListViews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import due.giuaky221121514202.R;
import due.giuaky221121514202.databinding.FragmentDay2ListviewBinding;

public class ListViewFragment extends Fragment{
    private FragmentDay2ListviewBinding binding;
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Bước 1: Inflate binding
        binding = FragmentDay2ListviewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Bước 2: Ánh xạ view qua binding
        initData();
        initView();

        mAdapter = new ContactAdapter(requireContext(), listContact);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContact.get(i);
                Toast.makeText(requireContext(), model.getName() + ": " + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }


    private void initView(){
        lvContact = binding.lvContact1;
    }

    private void initData(){
        listContact.add(new ContactModel("Nguoi so 1", "0987654321", R.drawable.anh2));
        listContact.add(new ContactModel("Nguoi so 2", "0987654322", R.drawable.anh3));
        listContact.add(new ContactModel("Nguoi so 3", "0987654323", R.drawable.anh4));
        listContact.add(new ContactModel("Nguoi so 4", "0987654324", R.drawable.anh5));
        listContact.add(new ContactModel("Nguoi so 5", "0987654325", R.drawable.anh2));
        listContact.add(new ContactModel("Nguoi so 6", "0987654326", R.drawable.anh3));
        listContact.add(new ContactModel("Nguoi so 7", "0987654327", R.drawable.anh4));
        listContact.add(new ContactModel("Nguoi so 8", "0987654328", R.drawable.anh5));
        listContact.add(new ContactModel("Nguoi so 9", "0987654329", R.drawable.anh2));
        listContact.add(new ContactModel("Nguoi so 10", "0987654330", R.drawable.anh3));
        listContact.add(new ContactModel("Nguoi so 11", "0987654331", R.drawable.anh4));
        listContact.add(new ContactModel("Nguoi so 12", "0987654332", R.drawable.anh5));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}