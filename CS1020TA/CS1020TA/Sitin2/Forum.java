import java.util.*;

public class Forum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Forum forum = new Forum();
		forum.run();
		int N, T, Q;

		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			forum.addUser(sc.next());
		}

		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			forum.addThread(sc.next());
		}

		Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			String query = sc.next();

            // stores return value to be printed out at the end
			String returnValue;
			// post THREADNAME USERNAME MESSAGE
			if (query.equals("post")) {
				String threadName = sc.next();
				String userName = sc.next();
				String message = sc.nextLine().trim();
				returnValue = forum.createPost(threadName, userName, message);

				// count K THREAD1 THREAD2 ... THREADK
			} else if (query.equals("count")) {
				sc.nextInt(); // Don't need to know the number of threads
				String params = sc.nextLine().trim();

                // Alternatively, there is a for loop here to read the thread
                // name from the scanner
                // and call the API to sum the number of posts here.
                // That's fine too.
				returnValue = forum.totalPostInThreads(params.split(" "));

			} else if (query.equals("numpost")) {
				returnValue = forum.getUserPostCount(sc.next());

			} else if (query.equals("maxpost")) {
				returnValue = forum.getMaxPosterName(sc.next());

			} else { // query.equals("content")
				String threadName = sc.next();
				int postNum = sc.nextInt();
				returnValue = forum.getPostContent(threadName, postNum);
			}
			System.out.println(returnValue);
		}
	}

	private HashMap<String, Thread> threads;
	private HashMap<String, User> users;

	public Forum() {
		threads = new HashMap<String, Thread>();
		users = new HashMap<String, User>();
	}

    // I feel that methods being called by main should be public
    // as the main method is not necessarily inside the Forum class,
    // but the consensus is that must penalize anyway :/
	public void addThread(String threadName) {
		threads.put(threadName, new Thread());
	}

	public void addUser(String userName) {
		users.put(userName, new User());
	}

    // query 1: post
	public String createPost(String threadName, String userName, String content) {
		if (!threads.containsKey(threadName)) return "no such thread";
		if (!users.containsKey(userName)) return "no such user";

		threads.get(threadName).createPost(userName, content);
		users.get(userName).incrementPostCount();
		return content;
	}

    // query 2: count
	public String totalPostInThreads(String[] threadNames) {
		int ans = 0;
		for (int i = 0; i < threadNames.length; i++) {
			ans += threads.get(threadNames[i]).getThreadLength();
		}
		return Integer.toString(ans);
	}

    // query 3: numpost
	public String getUserPostCount(String userName) {
		if (!users.containsKey(userName)) return "no such user";
		return Integer.toString(users.get(userName).getPostCount());
	}

    // query 4: maxpost
	public String getMaxPosterName(String threadName) {
		if (!threads.containsKey(threadName)) return "no such thread";
		String poster = threads.get(threadName).getMostActivePoster();
		return poster == null ? getDefaultUserName() : poster;
	}

    // query 5: content
	public String getPostContent(String threadName, int postNum) {
		if (!threads.containsKey(threadName)) return "no such thread";
		if (threads.get(threadName).getThreadLength() < postNum) return "no such post";
		return threads.get(threadName).getContentByPostNum(postNum);
	}

    // Notice helper method that is not being called by main is private.
    // Because this is just a helper and other classes other than Forum
    // no need to know about its existence.
	private String getDefaultUserName() {
		String currentSmallest = null;

        // If you don't know what this is about, no worries. You are
        // not expected to know about HashMap yet as of now.
		for (Map.Entry<String, User> userEntry : users.entrySet()) {
			if (currentSmallest == null) {
				currentSmallest = userEntry.getKey();
			}
			if (currentSmallest.compareTo(userEntry.getKey()) > 0) {
				currentSmallest = userEntry.getKey();
			}
		} 
		return currentSmallest;
	}
}

class Thread {
	private String name;
	private ArrayList<Post> posts;

	public Thread(String threadName) {
		name = threadName;
		posts = new ArrayList<Post>();
	}

	public void createPost(String poster, String content) {
		posts.add(new Post(poster, content));
	}

	public int getThreadLength() {
		return posts.size();
	}

	public String getContentByPostNum(int postNum) {
		return posts.get(postNum - 1).getContent();
	}

	public String getMostActivePoster() {
        // Alternative to HashMap<String, Integer>:
        // 2 ArrayList, 1 stores the users, the other the postcount of the user in the same index
		HashMap<String, Integer> userPostcountMap = new HashMap<String, Integer>();
		for (Post post : posts) {
			String user = post.getPoster();
			if (userPostcountMap.containsKey(user)) {
				userPostcountMap.put(user, userPostcountMap.get(user) + 1);
			} else {
				userPostcountMap.put(user, 1);
				postcount[i] += 2; // array
				postcount.get(i) += 2; XXXXX
				postcount.set(i, 2); // arraylist
			}
		}

		String maxUser = null;
		int maxPost = 0;
		for (Map.Entry<String, Integer> entry : userPostcountMap.entrySet()) {
			if (maxPost < entry.getValue()) {
				maxPost = entry.getValue();
				maxUser = entry.getKey();
			}

            // if 2 users have the same post count, take the user with lexi-smaller name
			if (maxPost == entry.getValue()) {
				maxUser = maxUser.compareTo(entry.getKey()) < 0 ? maxUser : entry.getKey();
			}
		}
		return maxUser;
	}
}

class Post {
	private String poster;
	private String content;

	public Post(String posterName, String postContent) {
		poster = posterName;
		content = postContent;
	}

	public String getContent() {
		return content;
	}

	public String getPoster() {
		return poster;
	}
}

class User {
	private int postCount;

	public User() {
		postCount = 0;
	}

	public void incrementPostCount() {
		postCount++;
	}

	public int getPostCount() {
		return postCount;
	}
}
