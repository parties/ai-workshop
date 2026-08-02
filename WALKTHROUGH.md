# Walkthrough: build the project, run the conversion

Start to finish, about fifteen minutes the first time and about two minutes every time after.

Works on **Claude**, **Gemini**, or **ChatGPT**. Free accounts are fine on all three. Nothing
to install, nothing to pay for, no verification needed.

---

## Before you start

- [ ] An account on one of the three. Free tier is fine.
- [ ] An assignment your students AI'd their way through, saved as a file — `.txt`, `.docx`, `.pdf`, `.md`, doesn't matter. No assignment? Use [`resources/sample-assignment.md`](resources/sample-assignment.md).
- [ ] This repo open in another tab.

> **One rule before you upload anything.** Your assignment, not your students' work. If you
> want to show it what a kid actually turned in, replace the name with "Student A" first. Full
> reasoning in [Student privacy](README.md#student-privacy).

---

## Step 1 — Create the container

This is the thing that holds your context so you stop re-typing it. Each platform calls it
something different. They all work the same way.

### Claude — a Project

1. Left sidebar → **Projects** → **New project**
2. Name it something you'll recognize: *"Assignment conversion"*
3. You'll see a place for **project knowledge** (files) and **instructions** (standing text)

### Gemini — a Gem

1. Left sidebar → **Gems** → **New Gem**
2. Name it *"Assignment conversion"*
3. You'll see **Instructions** and **Knowledge** — Knowledge takes up to 10 files

### ChatGPT — a Project or a Custom GPT

1. Left sidebar → **Projects** → **New project** (simplest), or
2. **Explore GPTs** → **Create** if you want something reusable you can share

> UIs move. If a menu doesn't match, look for the word "Project," "Gem," or "GPT" in the left
> sidebar — the concept is the same everywhere even when the buttons move.

---

## Step 2 — Give it the framework

Upload **[`resources/framework.md`](resources/framework.md)** into the project knowledge /
Knowledge / files area.

That's it. Don't paste it into the chat — put it in the *container*, so it applies to every
conversation you start there instead of just this one.

**Why this matters, and it's the whole point of the workshop:** every message you send resends
the entire conversation back to the model. Once a chat gets long enough, the earliest things
you said start falling out of range. But files and instructions attached to the *project* get
re-attached to every single message. That's why the project remembers and the chat forgets.

---

## Step 3 — Run the conversion

1. Start a new chat **inside** the project you just made
2. Copy a prompt — click **Raw** on GitHub first so you get clean text:
   - Brought your own assignment → [`prompts/conversion-prompt.md`](prompts/conversion-prompt.md)
   - Using the sample → [`prompts/conversion-prompt-prefilled.md`](prompts/conversion-prompt-prefilled.md) *(context already written, zero edits)*
3. Paste it into the chat
4. Fill in the **My context** section — skip this and you'll get generic output
5. Attach your assignment file
6. Send

**If it asks you a question instead of answering, that's correct.** The prompt tells it to ask
rather than invent details about your classroom. Answer the question and keep going.

### The context block is where all the quality comes from

Two lines carry most of the weight:

**"What my students genuinely cannot do yet"** — most people write what students *can* do. The
limits are what make the output usable.

**"What went wrong when students used AI on this"** — be specific.

| Weak | Strong |
|---|---|
| "They turned in something generic" | "All twenty-eight described the same three hazards in the same order, and nobody mentioned the equipment we actually use" |
| "It was obviously AI" | "Every paper concluded that safety is everyone's responsibility" |
| "They didn't learn anything" | "I couldn't tell from any of them whether a student could spot a hazard standing in our room" |

That last one is the model. Name the **assessment failure**, not the cheating.

---

## Step 4 — Push back on it

**This is the step everyone skips, and it's the one that matters.**

What comes back is a draft, not an answer. Read it against this checklist:

- [ ] Did the **verb** actually change? If the rewrite still says "write" or "describe," it didn't fix anything.
- [ ] Does the **format** make gaps visible? A table with an empty cell shows a hole. A paragraph hides one.
- [ ] Could a student still get the whole thing in **one prompt**? If yes, the gap is still there.
- [ ] Does it still fit your **class period**? Models love to make assignments bigger.
- [ ] Is your **actual objective** in there, or did it optimize for something adjacent?

Then say so, plainly, in the chat:

> *"You kept the same thinking gap in step 2 — a student can still ask for the whole table in one shot. Try again."*

> *"This is now a 90-minute assignment. I have 35 minutes of work time. Cut it down."*

> *"The verb is still 'explain.' Give me something with judgment in it."*

> *"You dropped the three-hazard requirement. That's tied to our certification checklist and it has to stay."*

Two or three rounds of this is normal. **That iteration is the thing you want your students
watching you do** — it's the difference between using a tool and being used by one.

---

## Step 5 — Keep what worked

Once the output is good:

- Save the rewritten assignment where you keep your materials
- **Add anything you had to explain twice to the project instructions.** If you told it "my kids can't read dense regulatory text" in three separate chats, that belongs in the container, not the conversation.

That's the whole loop. Next assignment takes two minutes because the context is already there.

---

## What good output looks like

You should get back five sections. Judge them like this:

| Section | It worked if | It failed if |
|---|---|---|
| **Diagnose the gap** | It says plainly that a student needed to know nothing | It compliments your assignment |
| **Rewrite** | Verb, Format, Voice, Context are labeled and the required thinking genuinely changed | It's the same task with fancier wording |
| **Show the difference** | Concrete and specific to your subject | Generic phrases like "deeper engagement" |
| **How to grade it** | At least one item involves reading the student's *prompt* | Only looks at the final product |
| **Weak points** | It found a real shortcut a student could still take | It tells you the assignment is great now |

If section five says nothing is wrong, it's flattering you. Ask again: *"Be harder on this.
Where would a motivated student still shortcut it?"*

---

## Troubleshooting

| Problem | Fix |
|---|---|
| Output is generic | The context block was thin. Add the two lines from Step 3. |
| It ignored the framework | Check the file actually uploaded to the **project**, not just attached to one message. Start a fresh chat inside the project. |
| It made the assignment huge | Tell it your real work time in minutes. Models optimize for thoroughness unless you stop them. |
| It rewrote something you have to keep | Say so directly. It's in the prompt's rules, but restate it — "the three-hazard requirement is non-negotiable." |
| Hit a message limit | Free tiers cap out. Wait it out, switch platforms, or pair up with someone. |
| Can't find Projects / Gems | Some school-managed accounts have features disabled by an admin. Try a personal account, or work with a neighbor. |

---

## Monday

1. Put **Verb · Format · Voice · Context** on the board. One assignment. No policy needed, no district rollout, no permission.
2. Do one prompt in front of the class, thinking out loud. Then build one together. Then let them go solo.
3. Send [the district email](README.md#the-email-to-send-monday).

The standard worth holding, from Tim Swick and Mark Davis:

> **If students can't explain these four parts, they shouldn't be using AI yet.**
