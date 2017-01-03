# MyDynamicRecyclerViewLibrary
This is an Android Library for developer to use customized recyclerview with many features, like easy use Empty view, Refresh view, Floating Action Button, Load more. So all these features contain in one recyclerview.
<br>
Example is avilable in app module.

<p>
<img src="https://github.com/vatsaldesai92/MyDynamicRecyclerviewLibrary/blob/master/app/src/main/assets/1.png" alt="screenshot" width="270">

<img src="https://github.com/vatsaldesai92/MyDynamicRecyclerviewLibrary/blob/master/app/src/main/assets/2.png" alt="screenshot" width="270">

<img src="https://github.com/vatsaldesai92/MyDynamicRecyclerviewLibrary/blob/master/app/src/main/assets/3.png" alt="screenshot" width="270">
</p>

##Download

###Gradle dependency:
- Add the following to your project level build.gradle:
~~~
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
~~~
- Add this to your app build.gradle:
~~~
dependencies {
	compile 'com.github.vatsaldesai92:MyDynamicRecyclerviewLibrary:1.0.1'
}
~~~

##Usage

- Add MyDynamicRecyclerView in xml file or dynamicaly careate in java file.
~~~
    <com.desai.vatsal.myrecylerviewlibrary.MyDynamicRecyclerView
		android:id="@+id/myRecyclerview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
	
	MyDynamicRecyclerView myRecyclerview = new MyDynamicRecyclerView(this);
~~~

- Set background & simple divider
~~~
	// set background color
    myRecyclerview.setBackgroundColor(Color.RED);	or	 myRecyclerview.setBackgroundColor("#854559");
	
	// set simple divider true/false , Divider will generate automatically if set SimpleDivider true.
    myRecyclerview.setSimpleDivider(true);
~~~

- Use information layout to show information to user, when internet is not avilable, record is not available etc.
~~~
	// setInfoIcon(icon, icon_color);
    myRecyclerview.setInfoIcon(R.drawable.ic_warning, "#856245");

	// setInfoTitle(text, text_size, text_color, text_typeface);
    myRecyclerview.setInfoTitle("No Internet Available", 18, Color.GRAY, null);

	// setInfoMessage(text, text_size, text_color, text_typeface);
    myRecyclerview.setInfoMessage("Please Swipe From Top For Refresh", 14, Color.GRAY, null);
	
	// Show Information & Hide recyclerview
	myRecyclerview.showInfoLayout();
	
	// Hide Information & Show recyclerview
    myRecyclerview.hideInfoLayout();	
~~~

- Use SwipeRefresh
~~~
	// set SwipeRefresh true/false
    myRecyclerview.setSwipeRefresh(true);
	
	// set SwipeRefresh colors
    myRecyclerview.setColorSchemeColors(Color.RED, Color.YELLOW, Color.BLACK, Color.GREEN, Color.BLUE);
	
	// set SwipeRefresh Listener
    myRecyclerview.setOnRefreshListener(new MyDynamicRecyclerView.SwipeRefreshListener() {
        @Override
        public void OnRefresh() {
			
			
        }
    });
	
	// stop SwipeRefresh
	myRecyclerview.stopSwipeRefresh();
~~~

- Use Floating Action Button
~~~
	// set Floating Action Button true/false
    myRecyclerview.setFAB(true);
	
    myRecyclerview.setFABMargins(20, 20, 20, 20);
    myRecyclerview.setFABImage(R.mipmap.ic_launcher);
    myRecyclerview.setFABRippleColor(Color.RED);
    myRecyclerview.setFABBackgroundTintMode(PorterDuff.Mode.DST_OVER);
    myRecyclerview.setFABImageColor("#845654");
    myRecyclerview.setFABBackgroundColor(Color.YELLOW);
	
    myRecyclerview.setFABOnClickListener(new MyDynamicRecyclerView.FABOnClickListener() {
        @Override
        public void OnClick() {


        }
    });
~~~

- Use Load More
~~~
	// set Load More true/false, if you want to use load more then pass object of LinearLayoutManager which is used in recyclerview
    myRecyclerview.setLoadMore(true, linearLayoutManager);
    
	// set Load More Listener, when recyclerview reach to it's last cell listener will execulte
    myRecyclerview.setLoadMoreListener(new MyDynamicRecyclerView.LoadMoreListener() {
        @Override
        public void OnLoadMore() {
                

        }
    });
~~~


##License
~~~
    Apache Version 2.0

    Copyright 2016.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
~~~
