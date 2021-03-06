/* Assignment 1: TravelClaim
 * Name: Brandon Cheung
 * CCID: bwcheung
 * Date: Feb 2, 2015
 * LICENSE: APACHE 2.0 (read the Readme file)
 * Source taken from: http://www.androidhive.info/2012/02/android-custom-listview-with-image-and-text/ -- Jan 31, 2015
 * Description: This is a custom adapter that lets me show my claims in a custom listview.
 */
package com.example.travelclaims;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {
	
	private static ArrayList<Claim> ClaimList;
	private LayoutInflater mInflater;

	public CustomBaseAdapter(Context context, ArrayList<Claim> claimlist) {
		ClaimList = claimlist;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return ClaimList.size();
	}

	public Object getItem(int position) {
		return ClaimList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams")
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.customviewlist, null);
			holder = new ViewHolder();
			holder.claim = (TextView) convertView.findViewById(R.id.customclaim);
			holder.date = (TextView) convertView.findViewById(R.id.customdate);
			holder.status = (TextView) convertView.findViewById(R.id.customstatus);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.claim.setText(ClaimList.get(position).getClaim());
		holder.date.setText(ClaimList.get(position).getDateRange());
		holder.status.setText(ClaimList.get(position).getStatus());
		
		return convertView;
	}

	static class ViewHolder {
		TextView claim;
		TextView date;
		TextView status;
	}
}
