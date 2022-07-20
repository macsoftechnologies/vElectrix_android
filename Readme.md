

#Model class converter
http://pojo.sodhanalibrary.com/

# Postman collections
https://www.getpostman.com/collections/1c151b80cdce17d3104d


Glide.with(mContext)
                .load(url)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .fitCenter()
                .placeholder(R.drawable.placeholder_h)
                .error(R.drawable.placeholder_h)
                .into((imageView));